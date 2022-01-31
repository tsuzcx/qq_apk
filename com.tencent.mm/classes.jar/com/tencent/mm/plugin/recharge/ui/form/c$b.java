package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c$b
{
  public List<String[]> pVt;
  public com.tencent.mm.plugin.recharge.model.a pVu = null;
  public MallFormView pXd = null;
  public d pXe;
  boolean pXf = false;
  
  public c$b(MallFormView paramMallFormView)
  {
    this.pXd = paramMallFormView;
  }
  
  public final void kr(boolean paramBoolean)
  {
    AppMethodBeat.i(44373);
    ab.d(c.access$100(), "needSetInput: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject1 = com.tencent.mm.plugin.recharge.a.a.cfm().cfn();
    Object localObject2;
    com.tencent.mm.plugin.recharge.model.a locala;
    if (localObject1 == null)
    {
      localObject2 = new ArrayList();
      locala = com.tencent.mm.plugin.recharge.a.a.cfo();
      localObject1 = localObject2;
      if (locala != null)
      {
        ((List)localObject2).add(locala);
        com.tencent.mm.plugin.recharge.a.a.cfm().a(locala);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      this.pXe.cH((List)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (paramBoolean))
      {
        this.pVu = ((com.tencent.mm.plugin.recharge.model.a)((List)localObject1).get(0));
        setInput(this.pVu);
      }
      AppMethodBeat.o(44373);
      return;
      localObject2 = (String)g.RL().Ru().get(6, null);
      int i = 0;
      if (i < ((List)localObject1).size())
      {
        locala = (com.tencent.mm.plugin.recharge.model.a)((List)localObject1).get(i);
        if ((!bo.isNullOrNil(locala.pUJ)) && (locala.pUJ.equals(localObject2))) {
          if ((bo.isNullOrNil(locala.name)) || (!locala.name.equals(this.pXd.getContext().getString(2131305571))))
          {
            locala.name = this.pXd.getContext().getString(2131305571);
            label247:
            break label302;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.recharge.a.a.cfm().cH((List)localObject1);
          do
          {
            i += 1;
            break;
          } while ((bo.isNullOrNil(locala.pUJ)) || (!bo.isNullOrNil(locala.name)) || (this.pVt == null));
          Iterator localIterator = this.pVt.iterator();
          label302:
          if (localIterator.hasNext())
          {
            String[] arrayOfString = (String[])localIterator.next();
            if (!locala.pUJ.equals(b.xw(arrayOfString[2]))) {
              break label247;
            }
            locala.name = arrayOfString[1];
            ab.i(c.access$100(), "add name: %s", new Object[] { arrayOfString[1] });
          }
        }
      }
    }
  }
  
  public final void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    AppMethodBeat.i(44372);
    this.pVu = parama;
    if (parama != null)
    {
      if ((bo.isNullOrNil(this.pXd.getText())) || (!this.pXd.getText().equals(parama.pUJ))) {
        this.pXd.getContentEditText().setText(b.XL(parama.pUJ));
      }
      this.pXd.getContentEditText().setSelection(this.pXd.getContentEditText().getText().length());
      ab.d(c.access$100(), "editTv.setText %s, name: %s, location: %s, type: %s", new Object[] { parama.pUJ, parama.name, parama.pUK, Integer.valueOf(parama.cpG) });
      Context localContext = this.pXd.getContext();
      if (this.pVu.cpG == 3)
      {
        this.pXd.getTipsTv().setText(this.pVu.name);
        this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690382));
        AppMethodBeat.o(44372);
        return;
      }
      if (this.pVu.cpG == 1)
      {
        if (!bo.isNullOrNil(this.pVu.name))
        {
          str = this.pVu.name;
          parama = str;
          if (!bo.isNullOrNil(this.pVu.pUK)) {
            parama = str + localContext.getString(2131305563, new Object[] { this.pVu.pUK });
          }
          this.pXd.getTipsTv().setText(parama);
          this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690322));
          AppMethodBeat.o(44372);
          return;
        }
        String str = localContext.getString(2131305573);
        parama = str;
        if (!bo.isNullOrNil(this.pVu.pUK)) {
          parama = str + localContext.getString(2131305563, new Object[] { this.pVu.pUK });
        }
        this.pXd.getTipsTv().setText(parama);
        this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690374));
        AppMethodBeat.o(44372);
        return;
      }
      if (this.pVu.cpG == 2)
      {
        if (!bo.isNullOrNil(this.pVu.pUK))
        {
          this.pXd.getTipsTv().setText(this.pVu.pUK);
          this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690322));
          AppMethodBeat.o(44372);
          return;
        }
        this.pXd.getTipsTv().setText("");
        this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690374));
        AppMethodBeat.o(44372);
        return;
      }
      if (this.pVu.cpG == 0)
      {
        if (!bo.isNullOrNil(this.pVu.pUK))
        {
          if (!bo.isNullOrNil(this.pVu.name))
          {
            this.pXd.getTipsTv().setText(this.pVu.name + localContext.getString(2131305563, new Object[] { this.pVu.pUK }));
            this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690374));
            AppMethodBeat.o(44372);
            return;
          }
          this.pXd.getTipsTv().setText(this.pVu.pUK);
          this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690322));
          AppMethodBeat.o(44372);
          return;
        }
        if (!bo.isNullOrNil(this.pVu.name))
        {
          this.pXd.getTipsTv().setText(this.pVu.name);
          this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690374));
          AppMethodBeat.o(44372);
          return;
        }
        this.pXd.getTipsTv().setText("");
        this.pXd.getTipsTv().setTextColor(localContext.getResources().getColor(2131690322));
      }
      AppMethodBeat.o(44372);
      return;
    }
    this.pXd.getContentEditText().setText("");
    ab.d(c.access$100(), "editTv.setText null");
    this.pXd.getTipsTv().setText("");
    AppMethodBeat.o(44372);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.b
 * JD-Core Version:    0.7.0.1
 */
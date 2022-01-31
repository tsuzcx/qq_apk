package com.tencent.mm.plugin.recharge.ui.form;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class c$b
{
  public List<String[]> nqf;
  public com.tencent.mm.plugin.recharge.model.a nqg = null;
  public MallFormView nrP = null;
  public d nrQ;
  boolean nrR = false;
  
  public c$b(MallFormView paramMallFormView)
  {
    this.nrP = paramMallFormView;
  }
  
  public final void ip(boolean paramBoolean)
  {
    y.d(c.access$100(), "needSetInput: %s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject1 = com.tencent.mm.plugin.recharge.a.a.bva().bvb();
    Object localObject2;
    com.tencent.mm.plugin.recharge.model.a locala;
    if (localObject1 == null)
    {
      localObject2 = new ArrayList();
      locala = com.tencent.mm.plugin.recharge.a.a.bvc();
      localObject1 = localObject2;
      if (locala != null)
      {
        ((List)localObject2).add(locala);
        com.tencent.mm.plugin.recharge.a.a.bva().a(locala);
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      this.nrQ.ce((List)localObject1);
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (paramBoolean))
      {
        this.nqg = ((com.tencent.mm.plugin.recharge.model.a)((List)localObject1).get(0));
        setInput(this.nqg);
      }
      return;
      localObject2 = (String)g.DP().Dz().get(6, null);
      int i = 0;
      if (i < ((List)localObject1).size())
      {
        locala = (com.tencent.mm.plugin.recharge.model.a)((List)localObject1).get(i);
        if ((!bk.bl(locala.npv)) && (locala.npv.equals(localObject2))) {
          if ((bk.bl(locala.name)) || (!locala.name.equals(this.nrP.getContext().getString(a.i.wallet_recharge_me))))
          {
            locala.name = this.nrP.getContext().getString(a.i.wallet_recharge_me);
            label239:
            break label294;
          }
        }
        for (;;)
        {
          com.tencent.mm.plugin.recharge.a.a.bva().ce((List)localObject1);
          do
          {
            i += 1;
            break;
          } while ((bk.bl(locala.npv)) || (!bk.bl(locala.name)) || (this.nqf == null));
          Iterator localIterator = this.nqf.iterator();
          label294:
          if (localIterator.hasNext())
          {
            String[] arrayOfString = (String[])localIterator.next();
            if (!locala.npv.equals(b.qa(arrayOfString[2]))) {
              break label239;
            }
            locala.name = arrayOfString[1];
            y.i(c.access$100(), "add name: %s", new Object[] { arrayOfString[1] });
          }
        }
      }
    }
  }
  
  public final void setInput(com.tencent.mm.plugin.recharge.model.a parama)
  {
    this.nqg = parama;
    if (parama != null)
    {
      if ((bk.bl(this.nrP.getText())) || (!this.nrP.getText().equals(parama.npv))) {
        this.nrP.getContentEditText().setText(b.LB(parama.npv));
      }
      this.nrP.getContentEditText().setSelection(this.nrP.getContentEditText().getText().length());
      y.d(c.access$100(), "editTv.setText %s, name: %s, location: %s, type: %s", new Object[] { parama.npv, parama.name, parama.npw, Integer.valueOf(parama.bIl) });
      Context localContext = this.nrP.getContext();
      if (this.nqg.bIl == 3)
      {
        this.nrP.getTipsTv().setText(this.nqg.name);
        this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.recharge_product_item_bg_clicked));
      }
      do
      {
        return;
        if (this.nqg.bIl == 1)
        {
          if (!bk.bl(this.nqg.name))
          {
            str = this.nqg.name;
            parama = str;
            if (!bk.bl(this.nqg.npw)) {
              parama = str + localContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { this.nqg.npw });
            }
            this.nrP.getTipsTv().setText(parama);
            this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.normal_text_color));
            return;
          }
          String str = localContext.getString(a.i.wallet_recharge_not_in_contact);
          parama = str;
          if (!bk.bl(this.nqg.npw)) {
            parama = str + localContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { this.nqg.npw });
          }
          this.nrP.getTipsTv().setText(parama);
          this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.recharge_err_text_color));
          return;
        }
        if (this.nqg.bIl == 2)
        {
          if (!bk.bl(this.nqg.npw))
          {
            this.nrP.getTipsTv().setText(this.nqg.npw);
            this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.normal_text_color));
            return;
          }
          this.nrP.getTipsTv().setText("");
          this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.recharge_err_text_color));
          return;
        }
      } while (this.nqg.bIl != 0);
      if (!bk.bl(this.nqg.npw))
      {
        if (!bk.bl(this.nqg.name))
        {
          this.nrP.getTipsTv().setText(this.nqg.name + localContext.getString(a.i.wallet_recharge_dest_wrapper, new Object[] { this.nqg.npw }));
          this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.recharge_err_text_color));
          return;
        }
        this.nrP.getTipsTv().setText(this.nqg.npw);
        this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.normal_text_color));
        return;
      }
      if (!bk.bl(this.nqg.name))
      {
        this.nrP.getTipsTv().setText(this.nqg.name);
        this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.recharge_err_text_color));
        return;
      }
      this.nrP.getTipsTv().setText("");
      this.nrP.getTipsTv().setTextColor(localContext.getResources().getColor(a.c.normal_text_color));
      return;
    }
    this.nrP.getContentEditText().setText("");
    y.d(c.access$100(), "editTv.setText null");
    this.nrP.getTipsTv().setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recharge.ui.form.c.b
 * JD-Core Version:    0.7.0.1
 */
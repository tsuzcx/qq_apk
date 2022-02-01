package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.e.a;
import com.tencent.mm.aj.f.c;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;
import junit.framework.Assert;

public class FriendPreference
  extends Preference
  implements e.a
{
  private ai contact;
  private int dqp;
  private String iIk;
  private MMActivity iMV;
  private boolean pDN;
  private TextView titleTv;
  private TextView vLf;
  private ImageView vLg;
  private ImageView vLh;
  private com.tencent.mm.plugin.account.friend.a.a vLi;
  private String vLj;
  private long vLk;
  private long vLl;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27235);
    this.iMV = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(27235);
  }
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(27236);
    setLayoutResource(2131494804);
    setWidgetLayoutResource(2131494884);
    init();
    AppMethodBeat.o(27236);
  }
  
  private void dqp()
  {
    AppMethodBeat.i(27240);
    if ((this.contact == null) || (!this.pDN))
    {
      ac.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.pDN);
      AppMethodBeat.o(27240);
      return;
    }
    this.dqp = 3;
    this.titleTv.setText(this.mContext.getString(2131760163));
    this.vLf.setText(bs.nullAsNil(this.contact.exM));
    Object localObject1 = com.tencent.mm.aj.c.zN(this.vLl);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label365:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(2131690032);
        localObject4 = localInputStream;
        localObject5 = localInputStream;
        Bitmap localBitmap = com.tencent.mm.compatible.e.a.decodeStream(localInputStream);
        localObject4 = localBitmap;
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (Exception localException4)
      {
        InputStream localInputStream;
        Object localObject2;
        localObject5 = localObject4;
        ac.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label365;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          ac.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        try
        {
          localObject5.close();
          AppMethodBeat.o(27240);
          throw localObject3;
        }
        catch (Exception localException3)
        {
          ac.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
          continue;
        }
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 78, 78, false);
        if (localObject4 != localObject1)
        {
          ac.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject4, true, 0.0F);
        this.vLg.setImageBitmap((Bitmap)localObject1);
      }
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        this.vLg.setBackgroundDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690013));
      }
      AppMethodBeat.o(27240);
      return;
    }
  }
  
  private void dqq()
  {
    AppMethodBeat.i(27241);
    if ((this.contact == null) || (!this.pDN))
    {
      ac.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.pDN);
      AppMethodBeat.o(27241);
      return;
    }
    this.dqp = 2;
    this.titleTv.setText(this.mContext.getString(2131757681));
    Object localObject1 = bs.nullAsNil(this.vLj);
    localObject1 = (String)localObject1 + " " + new com.tencent.mm.b.p(this.vLk).longValue();
    this.vLf.setText((CharSequence)localObject1);
    localObject1 = com.tencent.mm.aj.c.pP(this.vLk);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label390:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(2131690032);
        localObject4 = localInputStream;
        localObject5 = localInputStream;
        Bitmap localBitmap = com.tencent.mm.compatible.e.a.decodeStream(localInputStream);
        localObject4 = localBitmap;
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (Exception localException4)
      {
        InputStream localInputStream;
        Object localObject2;
        localObject5 = localObject4;
        ac.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label390;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          ac.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        try
        {
          localObject5.close();
          AppMethodBeat.o(27241);
          throw localObject3;
        }
        catch (Exception localException3)
        {
          ac.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
          continue;
        }
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        ac.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 78, 78, false);
        if (localObject4 != localObject1)
        {
          ac.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject4, true, 0.0F);
        this.vLg.setImageBitmap((Bitmap)localObject1);
      }
      az.ayM();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        this.vLg.setBackgroundDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690013));
      }
      AppMethodBeat.o(27241);
      return;
    }
  }
  
  private void dqr()
  {
    AppMethodBeat.i(27242);
    if ((this.contact == null) || (!this.pDN))
    {
      ac.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.pDN);
      AppMethodBeat.o(27242);
      return;
    }
    if (this.vLi == null)
    {
      AppMethodBeat.o(27242);
      return;
    }
    this.dqp = 1;
    this.titleTv.setText(this.mContext.getString(2131757680));
    final String str = bs.nullAsNil(this.vLi.aPm()) + " " + bs.nullAsNil(this.vLi.aPr()).replace(" ", "");
    this.vLf.setText(str);
    Bitmap localBitmap = com.tencent.mm.plugin.account.friend.a.l.a(this.vLi.aPl(), this.mContext);
    if (localBitmap == null) {
      this.vLg.setImageDrawable(com.tencent.mm.cc.a.l(this.iMV, 2131690027));
    }
    for (;;)
    {
      az.ayM();
      if (!com.tencent.mm.model.c.awB().aNo(this.vLi.getUsername())) {
        break;
      }
      this.vLh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27233);
          if ((FriendPreference.a(FriendPreference.this) != null) && (!bs.isNullOrNil(FriendPreference.a(FriendPreference.this).huz))) {}
          for (paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(2130903076);; paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(2130903077))
          {
            Object localObject = paramAnonymousView;
            if (b.iyy.Lo())
            {
              paramAnonymousView = bs.S(paramAnonymousView);
              paramAnonymousView.add(FriendPreference.b(FriendPreference.this).getResources().getString(2131757266));
              localObject = (String[])paramAnonymousView.toArray(new String[paramAnonymousView.size()]);
              com.tencent.mm.plugin.report.service.h.wUl.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
            }
            com.tencent.mm.ui.base.h.a(FriendPreference.b(FriendPreference.this), null, (String[])localObject, null, new h.c()
            {
              public final void kG(int paramAnonymous2Int)
              {
                AppMethodBeat.i(27232);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(27232);
                  return;
                  if ((FriendPreference.1.this.vLm == null) || (FriendPreference.1.this.vLm.length() == 0))
                  {
                    AppMethodBeat.o(27232);
                    return;
                  }
                  paramAnonymous2Int = FriendPreference.1.this.vLm.lastIndexOf(' ') + 1;
                  if (paramAnonymous2Int > 0)
                  {
                    FriendPreference.a(FriendPreference.this, FriendPreference.1.this.vLm.substring(paramAnonymous2Int));
                    AppMethodBeat.o(27232);
                    return;
                    if ((FriendPreference.1.this.vLm == null) || (FriendPreference.1.this.vLm.length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    paramAnonymous2Int = FriendPreference.1.this.vLm.lastIndexOf(' ');
                    Object localObject = FriendPreference.1.this.vLm.substring(0, paramAnonymous2Int);
                    if ((localObject == null) || (((String)localObject).length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    w.c(FriendPreference.c(FriendPreference.this), ((String)localObject).trim());
                    AppMethodBeat.o(27232);
                    return;
                    if ((this.koN == null) || (this.koN.length <= 2) || (FriendPreference.a(FriendPreference.this) == null) || (FriendPreference.c(FriendPreference.this) == null))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    if ((FriendPreference.a(FriendPreference.this) != null) && (!bs.isNullOrNil(FriendPreference.a(FriendPreference.this).huz)))
                    {
                      FriendPreference.a(FriendPreference.this, FriendPreference.c(FriendPreference.this).field_username, FriendPreference.a(FriendPreference.this).huz);
                      AppMethodBeat.o(27232);
                      return;
                    }
                    localObject = new Intent();
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("fromScene", 2);
                    ((Intent)localObject).putExtra("reportArgs", localBundle);
                    b.iyx.j((Intent)localObject, FriendPreference.b(FriendPreference.this));
                  }
                }
              }
            });
            AppMethodBeat.o(27233);
            return;
          }
        }
      });
      AppMethodBeat.o(27242);
      return;
      localBitmap = com.tencent.mm.sdk.platformtools.f.a(Bitmap.createScaledBitmap(localBitmap, 78, 78, false), true, 0.0F);
      this.vLg.setImageBitmap(localBitmap);
    }
    this.vLh.setVisibility(4);
    AppMethodBeat.o(27242);
  }
  
  private void dqs()
  {
    AppMethodBeat.i(27243);
    if ((this.contact == null) || (!this.pDN))
    {
      ac.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.pDN);
      AppMethodBeat.o(27243);
      return;
    }
    this.dqp = 3;
    this.titleTv.setText(this.mContext.getString(2131762277));
    this.vLf.setText(bs.nullAsNil(this.iIk));
    this.vLg.setVisibility(8);
    AppMethodBeat.o(27243);
  }
  
  private void init()
  {
    this.pDN = false;
    this.contact = null;
    this.vLi = null;
    this.vLj = "";
    this.vLk = 0L;
    this.vLl = 0L;
    this.dqp = 0;
    this.iIk = "";
  }
  
  private void initView()
  {
    AppMethodBeat.i(27239);
    if ((this.contact == null) || (!this.pDN))
    {
      ac.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.pDN);
      AppMethodBeat.o(27239);
      return;
    }
    if ((this.vLk != -1L) && (new com.tencent.mm.b.p(this.vLk).longValue() > 0L))
    {
      setWidgetLayoutResource(2131494885);
      dqq();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.vLi != null)
    {
      setWidgetLayoutResource(2131494874);
      dqr();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.vLl > 0L)
    {
      dqp();
      AppMethodBeat.o(27239);
      return;
    }
    if (!TextUtils.isEmpty(this.iIk))
    {
      dqs();
      AppMethodBeat.o(27239);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(27239);
  }
  
  private boolean q(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(27244);
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      boolean bool = com.tencent.mm.plugin.account.friend.a.l.a(paramString, this.mContext, localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(27244);
      return bool;
    }
    AppMethodBeat.o(27244);
    return false;
  }
  
  public final void Af(String paramString)
  {
    AppMethodBeat.i(27246);
    long l = com.tencent.mm.aj.c.zP(paramString);
    if ((l > 0L) && (this.vLk == l) && (com.tencent.mm.aj.c.a(paramString, false, -1, null) != null)) {
      initView();
    }
    if ((com.tencent.mm.aj.c.zO(paramString) == this.vLl) && (com.tencent.mm.aj.c.a(paramString, false, -1, null) != null)) {
      initView();
    }
    AppMethodBeat.o(27246);
  }
  
  public final boolean bYJ()
  {
    AppMethodBeat.i(27245);
    com.tencent.mm.aj.p.aBh().e(this);
    AppMethodBeat.o(27245);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27238);
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.vLf = ((TextView)paramView.findViewById(2131305546));
    this.vLg = ((ImageView)paramView.findViewById(2131300943));
    this.vLh = ((ImageView)paramView.findViewById(2131302366));
    this.pDN = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(27238);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(27237);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131298739);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2131494827, localViewGroup);
    AppMethodBeat.o(27237);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.profile.b;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
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
  private af contact;
  private int dsF;
  private String iic;
  private MMActivity imP;
  private boolean paC;
  private TextView titleTv;
  private TextView uCm;
  private ImageView uCn;
  private ImageView uCo;
  private com.tencent.mm.plugin.account.friend.a.a uCp;
  private String uCq;
  private long uCr;
  private long uCs;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(27235);
    this.imP = ((MMActivity)paramContext);
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
  
  private void dcH()
  {
    AppMethodBeat.i(27240);
    if ((this.contact == null) || (!this.paC))
    {
      ad.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.paC);
      AppMethodBeat.o(27240);
      return;
    }
    this.dsF = 3;
    this.titleTv.setText(this.mContext.getString(2131760163));
    this.uCm.setText(bt.nullAsNil(this.contact.evq));
    Object localObject1 = com.tencent.mm.ak.c.vH(this.uCs);
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
        ad.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label365;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
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
          ad.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
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
        ad.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 48, 48, false);
        if (localObject4 != localObject1)
        {
          ad.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject4, true, 0.0F);
        this.uCn.setImageBitmap((Bitmap)localObject1);
      }
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        this.uCn.setBackgroundDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690013));
      }
      AppMethodBeat.o(27240);
      return;
    }
  }
  
  private void dcI()
  {
    AppMethodBeat.i(27241);
    if ((this.contact == null) || (!this.paC))
    {
      ad.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.paC);
      AppMethodBeat.o(27241);
      return;
    }
    this.dsF = 2;
    this.titleTv.setText(this.mContext.getString(2131757681));
    Object localObject1 = bt.nullAsNil(this.uCq);
    localObject1 = (String)localObject1 + " " + new com.tencent.mm.b.p(this.uCr).longValue();
    this.uCm.setText((CharSequence)localObject1);
    localObject1 = com.tencent.mm.ak.c.mb(this.uCr);
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
        ad.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label390;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          ad.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
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
          ad.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
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
        ad.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 48, 48, false);
        if (localObject4 != localObject1)
        {
          ad.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.f.a((Bitmap)localObject4, true, 0.0F);
        this.uCn.setImageBitmap((Bitmap)localObject1);
      }
      az.arV();
      if (!com.tencent.mm.model.c.isSDCardAvailable()) {
        this.uCn.setBackgroundDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690013));
      }
      AppMethodBeat.o(27241);
      return;
    }
  }
  
  private void dcJ()
  {
    AppMethodBeat.i(27242);
    if ((this.contact == null) || (!this.paC))
    {
      ad.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.paC);
      AppMethodBeat.o(27242);
      return;
    }
    if (this.uCp == null)
    {
      AppMethodBeat.o(27242);
      return;
    }
    this.dsF = 1;
    this.titleTv.setText(this.mContext.getString(2131757680));
    final String str = bt.nullAsNil(this.uCp.aIv()) + " " + bt.nullAsNil(this.uCp.aIA()).replace(" ", "");
    this.uCm.setText(str);
    Bitmap localBitmap = com.tencent.mm.plugin.account.friend.a.l.a(this.uCp.aIu(), this.mContext);
    if (localBitmap == null) {
      this.uCn.setImageDrawable(com.tencent.mm.cd.a.l(this.imP, 2131690027));
    }
    for (;;)
    {
      az.arV();
      if (!com.tencent.mm.model.c.apM().aHT(this.uCp.getUsername())) {
        break;
      }
      this.uCo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(27233);
          if ((FriendPreference.a(FriendPreference.this) != null) && (!bt.isNullOrNil(FriendPreference.a(FriendPreference.this).gUa))) {}
          for (paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(2130903076);; paramAnonymousView = FriendPreference.b(FriendPreference.this).getResources().getStringArray(2130903077))
          {
            Object localObject = paramAnonymousView;
            if (b.hYu.Lq())
            {
              paramAnonymousView = bt.S(paramAnonymousView);
              paramAnonymousView.add(FriendPreference.b(FriendPreference.this).getResources().getString(2131757266));
              localObject = (String[])paramAnonymousView.toArray(new String[paramAnonymousView.size()]);
              com.tencent.mm.plugin.report.service.h.vKh.f(11621, new Object[] { Integer.valueOf(2), Integer.valueOf(3) });
            }
            com.tencent.mm.ui.base.h.a(FriendPreference.b(FriendPreference.this), null, (String[])localObject, null, new h.c()
            {
              public final void kM(int paramAnonymous2Int)
              {
                AppMethodBeat.i(27232);
                switch (paramAnonymous2Int)
                {
                }
                for (;;)
                {
                  AppMethodBeat.o(27232);
                  return;
                  if ((FriendPreference.1.this.uCt == null) || (FriendPreference.1.this.uCt.length() == 0))
                  {
                    AppMethodBeat.o(27232);
                    return;
                  }
                  paramAnonymous2Int = FriendPreference.1.this.uCt.lastIndexOf(' ') + 1;
                  if (paramAnonymous2Int > 0)
                  {
                    FriendPreference.a(FriendPreference.this, FriendPreference.1.this.uCt.substring(paramAnonymous2Int));
                    AppMethodBeat.o(27232);
                    return;
                    if ((FriendPreference.1.this.uCt == null) || (FriendPreference.1.this.uCt.length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    paramAnonymous2Int = FriendPreference.1.this.uCt.lastIndexOf(' ');
                    Object localObject = FriendPreference.1.this.uCt.substring(0, paramAnonymous2Int);
                    if ((localObject == null) || (((String)localObject).length() == 0))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    w.c(FriendPreference.c(FriendPreference.this), ((String)localObject).trim());
                    AppMethodBeat.o(27232);
                    return;
                    if ((this.jOm == null) || (this.jOm.length <= 2) || (FriendPreference.a(FriendPreference.this) == null) || (FriendPreference.c(FriendPreference.this) == null))
                    {
                      AppMethodBeat.o(27232);
                      return;
                    }
                    if ((FriendPreference.a(FriendPreference.this) != null) && (!bt.isNullOrNil(FriendPreference.a(FriendPreference.this).gUa)))
                    {
                      FriendPreference.a(FriendPreference.this, FriendPreference.c(FriendPreference.this).field_username, FriendPreference.a(FriendPreference.this).gUa);
                      AppMethodBeat.o(27232);
                      return;
                    }
                    localObject = new Intent();
                    Bundle localBundle = new Bundle();
                    localBundle.putInt("fromScene", 2);
                    ((Intent)localObject).putExtra("reportArgs", localBundle);
                    b.hYt.j((Intent)localObject, FriendPreference.b(FriendPreference.this));
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
      localBitmap = com.tencent.mm.sdk.platformtools.f.a(Bitmap.createScaledBitmap(localBitmap, 48, 48, false), true, 0.0F);
      this.uCn.setImageBitmap(localBitmap);
    }
    this.uCo.setVisibility(4);
    AppMethodBeat.o(27242);
  }
  
  private void dcK()
  {
    AppMethodBeat.i(27243);
    if ((this.contact == null) || (!this.paC))
    {
      ad.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.paC);
      AppMethodBeat.o(27243);
      return;
    }
    this.dsF = 3;
    this.titleTv.setText(this.mContext.getString(2131762277));
    this.uCm.setText(bt.nullAsNil(this.iic));
    this.uCn.setVisibility(8);
    AppMethodBeat.o(27243);
  }
  
  private void init()
  {
    this.paC = false;
    this.contact = null;
    this.uCp = null;
    this.uCq = "";
    this.uCr = 0L;
    this.uCs = 0L;
    this.dsF = 0;
    this.iic = "";
  }
  
  private void initView()
  {
    AppMethodBeat.i(27239);
    if ((this.contact == null) || (!this.paC))
    {
      ad.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.paC);
      AppMethodBeat.o(27239);
      return;
    }
    if ((this.uCr != -1L) && (new com.tencent.mm.b.p(this.uCr).longValue() > 0L))
    {
      setWidgetLayoutResource(2131494885);
      dcI();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.uCp != null)
    {
      setWidgetLayoutResource(2131494874);
      dcJ();
      AppMethodBeat.o(27239);
      return;
    }
    if (this.uCs > 0L)
    {
      dcH();
      AppMethodBeat.o(27239);
      return;
    }
    if (!TextUtils.isEmpty(this.iic))
    {
      dcK();
      AppMethodBeat.o(27239);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(27239);
  }
  
  private boolean r(String paramString, Bitmap paramBitmap)
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
  
  public final boolean bRu()
  {
    AppMethodBeat.i(27245);
    com.tencent.mm.ak.p.auq().e(this);
    AppMethodBeat.o(27245);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(27238);
    this.titleTv = ((TextView)paramView.findViewById(2131305902));
    this.uCm = ((TextView)paramView.findViewById(2131305546));
    this.uCn = ((ImageView)paramView.findViewById(2131300943));
    this.uCo = ((ImageView)paramView.findViewById(2131302366));
    this.paC = true;
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
  
  public final void vZ(String paramString)
  {
    AppMethodBeat.i(27246);
    long l = com.tencent.mm.ak.c.vJ(paramString);
    if ((l > 0L) && (this.uCr == l) && (com.tencent.mm.ak.c.a(paramString, false, -1, null) != null)) {
      initView();
    }
    if ((com.tencent.mm.ak.c.vI(paramString) == this.uCs) && (com.tencent.mm.ak.c.a(paramString, false, -1, null) != null)) {
      initView();
    }
    AppMethodBeat.o(27246);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */
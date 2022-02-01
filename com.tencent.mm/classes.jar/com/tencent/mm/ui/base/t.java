package com.tencent.mm.ui.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public final class t
  extends Toast
{
  private View Joj;
  public final av cXg;
  private final Context context;
  public long duration;
  private int level;
  public int oIZ;
  private final TextView uQO;
  
  public t(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(142239);
    this.cXg = new av(new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(142230);
        if (t.a(t.this) == -1L)
        {
          t.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        t.b(t.this);
        if (t.c(t.this) >= 0)
        {
          t.this.show();
          AppMethodBeat.o(142230);
          return true;
        }
        t.this.cancel();
        AppMethodBeat.o(142230);
        return false;
      }
    }, true);
    this.context = paramContext;
    reset();
    this.Joj = View.inflate(paramContext, 2131495766, null);
    setView(this.Joj);
    setGravity(55, 0, BackwardSupportUtil.b.g(paramContext, 40.0F));
    setDuration(0);
    this.uQO = ((TextView)this.Joj.findViewById(2131305958));
    switch (this.level)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(142239);
      return;
      this.uQO.setTextColor(-1);
      AppMethodBeat.o(142239);
      return;
      this.uQO.setTextColor(this.context.getResources().getColor(2131101038));
    }
  }
  
  public static o a(Activity paramActivity, String paramString, long paramLong)
  {
    AppMethodBeat.i(142242);
    Object localObject = View.inflate(paramActivity, 2131495766, null);
    ((TextView)((View)localObject).findViewById(2131305958)).setText(paramString);
    paramString = new o((View)localObject);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).top;
    int j = dT(paramActivity);
    paramString.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, i + j);
    new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(142233);
        this.Jol.dismiss();
        super.handleMessage(paramAnonymousMessage);
        AppMethodBeat.o(142233);
      }
    }.sendEmptyMessageDelayed(0, paramLong);
    AppMethodBeat.o(142242);
    return paramString;
  }
  
  public static void a(Context paramContext, String paramString, t.b paramb)
  {
    AppMethodBeat.i(186476);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)paramContext.findViewById(2131305956)).setImageResource(2131690416);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    paramb.ec(paramContext);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(186476);
  }
  
  public static void cm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142246);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(142246);
  }
  
  public static void cn(Context paramContext, String paramString)
  {
    AppMethodBeat.i(142247);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)paramContext.findViewById(2131305956)).setImageResource(2131690416);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(142247);
  }
  
  private static int dT(Context paramContext)
  {
    AppMethodBeat.i(142243);
    int i;
    if (((paramContext instanceof AppCompatActivity)) && (((AppCompatActivity)paramContext).getSupportActionBar() != null)) {
      i = ((AppCompatActivity)paramContext).getSupportActionBar().getHeight();
    }
    while (i == 0)
    {
      i = paramContext.getResources().getDimensionPixelSize(2131165252);
      AppMethodBeat.o(142243);
      return i;
      DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels) {
        i = paramContext.getResources().getDimensionPixelSize(2131165251);
      } else {
        i = paramContext.getResources().getDimensionPixelSize(2131165252);
      }
    }
    AppMethodBeat.o(142243);
    return i;
  }
  
  public static void g(Context paramContext, View paramView)
  {
    AppMethodBeat.i(164156);
    if (((paramContext instanceof Activity)) && (android.support.v4.content.b.checkSelfPermission((Activity)paramContext, "android.permission.WRITE_EXTERNAL_STORAGE") != 0))
    {
      com.tencent.mm.ui.widget.snackbar.b.a(paramContext, paramView, paramContext.getString(2131761884), paramContext.getString(2131755889), new t.4(paramContext));
      AppMethodBeat.o(164156);
      return;
    }
    kg(paramContext);
    AppMethodBeat.o(164156);
  }
  
  public static int jW(Context paramContext)
  {
    AppMethodBeat.i(221155);
    int i = al.aL(paramContext, 25);
    AppMethodBeat.o(221155);
    return i;
  }
  
  public static void kg(Context paramContext)
  {
    AppMethodBeat.i(142248);
    if (g.getExternalStorageState().equals("mounted_ro"))
    {
      t.a.aO(paramContext, 3);
      AppMethodBeat.o(142248);
      return;
    }
    t.a.aO(paramContext, 1);
    AppMethodBeat.o(142248);
  }
  
  public static void kh(Context paramContext)
  {
    AppMethodBeat.i(142249);
    t.a.aO(paramContext, 2);
    AppMethodBeat.o(142249);
  }
  
  public static o m(final Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(186474);
    View localView = View.inflate(paramActivity, 2131494586, null);
    Object localObject = (TextView)localView.findViewById(2131301455);
    ((TextView)localObject).setText(paramString);
    ((TextView)localObject).setOnClickListener(null);
    ((ImageView)localView.findViewById(2131301454)).setVisibility(8);
    paramString = new o(localView);
    paramString.setWidth(-1);
    paramString.setHeight(-2);
    localObject = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int j = ((Rect)localObject).top;
    int k = dT(paramActivity);
    int i = j;
    if (j == 0) {
      i = al.aL(paramActivity, 25);
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142237);
        this.Jol.showAtLocation(paramActivity.getWindow().getDecorView(), 48, 0, this.Jon);
        AppMethodBeat.o(142237);
      }
    });
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(142231);
        this.Jol.dismiss();
        AppMethodBeat.o(142231);
      }
    }, 2000L);
    paramActivity = (ImageButton)localView.findViewById(2131301453);
    paramActivity.setVisibility(8);
    paramActivity.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(142232);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        this.Jol.dismiss();
        a.a(this, "com/tencent/mm/ui/base/MMToast$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(142232);
      }
    });
    AppMethodBeat.o(186474);
    return paramString;
  }
  
  public static void w(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(186475);
    Toast localToast = Toast.makeText(paramContext, "", 0);
    paramContext = View.inflate(paramContext, 2131493368, null);
    ((WeImageView)paramContext.findViewById(2131305956)).setImageResource(paramInt);
    ((TextView)paramContext.findViewById(2131305957)).setText(paramString);
    localToast.setGravity(17, 0, 0);
    localToast.setView(paramContext);
    localToast.show();
    AppMethodBeat.o(186475);
  }
  
  public final void reset()
  {
    this.level = 1;
    this.duration = 2000L;
    this.oIZ = ((int)(this.duration / 70L) + 1);
  }
  
  public final void setText(int paramInt)
  {
    AppMethodBeat.i(142241);
    this.uQO.setText(paramInt);
    AppMethodBeat.o(142241);
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(142240);
    this.uQO.setText(paramCharSequence);
    AppMethodBeat.o(142240);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.base.t
 * JD-Core Version:    0.7.0.1
 */
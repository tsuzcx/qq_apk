package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import java.util.ArrayList;
import java.util.Iterator;

public class XWalkDialogManager
{
  public static final int DIALOG_ARCHITECTURE_MISMATCH = 4;
  public static final int DIALOG_DECOMPRESSING = 11;
  public static final int DIALOG_DOWNLOADING = 12;
  public static final int DIALOG_DOWNLOAD_ERROR = 6;
  public static final int DIALOG_NEWER_VERSION = 3;
  public static final int DIALOG_NOT_FOUND = 1;
  public static final int DIALOG_OLDER_VERSION = 2;
  public static final int DIALOG_SELECT_STORE = 7;
  public static final int DIALOG_SIGNATURE_CHECK_ERROR = 5;
  public static final int DIALOG_UNSUPPORTED_STORE = 8;
  private static final String TAG = "XWalkLib";
  private Dialog mActiveDialog;
  private AlertDialog mArchitectureMismatchDialog;
  private Context mContext;
  private ProgressDialog mDecompressingDialog;
  private AlertDialog mDownloadErrorDialog;
  private ProgressDialog mDownloadingDialog;
  private AlertDialog mNewerVersionDialog;
  private AlertDialog mNotFoundDialog;
  private AlertDialog mOlderVersionDialog;
  private AlertDialog mSelectStoreDialog;
  private AlertDialog mSignatureCheckErrorDialog;
  private AlertDialog mUnsupportedStoreDialog;
  
  public XWalkDialogManager(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private AlertDialog buildAlertDialog()
  {
    AppMethodBeat.i(154708);
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.mContext).create();
    localAlertDialog.setIcon(17301543);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(154708);
    return localAlertDialog;
  }
  
  private ProgressDialog buildProgressDialog()
  {
    AppMethodBeat.i(154709);
    ProgressDialog localProgressDialog = new ProgressDialog(this.mContext);
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    localProgressDialog.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(154709);
    return localProgressDialog;
  }
  
  private void setMessage(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(154711);
    setMessage(paramAlertDialog, this.mContext.getString(paramInt));
    AppMethodBeat.o(154711);
  }
  
  private void setMessage(AlertDialog paramAlertDialog, String paramString)
  {
    AppMethodBeat.i(154712);
    String str = paramString.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
    paramString = str;
    if (str.startsWith("this")) {
      paramString = str.replaceFirst("this", "This");
    }
    paramAlertDialog.setMessage(paramString);
    AppMethodBeat.o(154712);
  }
  
  private void setNegativeButton(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(154714);
    paramAlertDialog.setButton(-2, this.mContext.getString(paramInt), null);
    AppMethodBeat.o(154714);
  }
  
  private void setPositiveButton(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(154713);
    paramAlertDialog.setButton(-1, this.mContext.getString(paramInt), null);
    AppMethodBeat.o(154713);
  }
  
  private void setTitle(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(154710);
    paramAlertDialog.setTitle(this.mContext.getString(paramInt));
    AppMethodBeat.o(154710);
  }
  
  private void showDialog(final AlertDialog paramAlertDialog, final ArrayList<ButtonAction> paramArrayList)
  {
    AppMethodBeat.i(154715);
    paramAlertDialog.setOnShowListener(new DialogInterface.OnShowListener()
    {
      public void onShow(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(154694);
        paramAnonymousDialogInterface = paramArrayList.iterator();
        while (paramAnonymousDialogInterface.hasNext())
        {
          XWalkDialogManager.ButtonAction localButtonAction = (XWalkDialogManager.ButtonAction)paramAnonymousDialogInterface.next();
          Button localButton = paramAlertDialog.getButton(localButtonAction.mWhich);
          if (localButton == null)
          {
            if (localButtonAction.mMandatory)
            {
              paramAnonymousDialogInterface = new RuntimeException("Button " + localButtonAction.mWhich + " is mandatory");
              AppMethodBeat.o(154694);
              throw paramAnonymousDialogInterface;
            }
          }
          else if (localButtonAction.mClickAction != null) {
            localButton.setOnClickListener(new View.OnClickListener()
            {
              private byte _hellAccFlag_;
              
              public void onClick(View paramAnonymous2View)
              {
                AppMethodBeat.i(154693);
                b localb = new b();
                localb.bm(paramAnonymous2View);
                a.b("org/xwalk/core/XWalkDialogManager$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                XWalkDialogManager.this.dismissDialog();
                this.val$command.run();
                a.a(this, "org/xwalk/core/XWalkDialogManager$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(154693);
              }
            });
          }
        }
        AppMethodBeat.o(154694);
      }
    });
    this.mActiveDialog = paramAlertDialog;
    this.mActiveDialog.show();
    AppMethodBeat.o(154715);
  }
  
  void dismissDialog()
  {
    AppMethodBeat.i(154705);
    this.mActiveDialog.dismiss();
    this.mActiveDialog = null;
    AppMethodBeat.o(154705);
  }
  
  public AlertDialog getAlertDialog(int paramInt)
  {
    AppMethodBeat.i(154697);
    if (paramInt == 1)
    {
      if (this.mNotFoundDialog == null)
      {
        this.mNotFoundDialog = buildAlertDialog();
        setTitle(this.mNotFoundDialog, 2131766388);
        setMessage(this.mNotFoundDialog, 2131766387);
        setPositiveButton(this.mNotFoundDialog, 2131768876);
        setNegativeButton(this.mNotFoundDialog, 2131768874);
      }
      localObject = this.mNotFoundDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 2)
    {
      if (this.mOlderVersionDialog == null)
      {
        this.mOlderVersionDialog = buildAlertDialog();
        setTitle(this.mOlderVersionDialog, 2131766390);
        setMessage(this.mOlderVersionDialog, 2131766389);
        setPositiveButton(this.mOlderVersionDialog, 2131768876);
        setNegativeButton(this.mOlderVersionDialog, 2131768874);
      }
      localObject = this.mOlderVersionDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 3)
    {
      if (this.mNewerVersionDialog == null)
      {
        this.mNewerVersionDialog = buildAlertDialog();
        setTitle(this.mNewerVersionDialog, 2131766386);
        setMessage(this.mNewerVersionDialog, 2131766385);
        setNegativeButton(this.mNewerVersionDialog, 2131768874);
      }
      localObject = this.mNewerVersionDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 4)
    {
      if (this.mArchitectureMismatchDialog == null)
      {
        this.mArchitectureMismatchDialog = buildAlertDialog();
        setTitle(this.mArchitectureMismatchDialog, 2131766383);
        setMessage(this.mArchitectureMismatchDialog, 2131766382);
        setPositiveButton(this.mArchitectureMismatchDialog, 2131768876);
        setNegativeButton(this.mArchitectureMismatchDialog, 2131768874);
      }
      localObject = this.mArchitectureMismatchDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 5)
    {
      if (this.mSignatureCheckErrorDialog == null)
      {
        this.mSignatureCheckErrorDialog = buildAlertDialog();
        setTitle(this.mSignatureCheckErrorDialog, 2131766393);
        setMessage(this.mSignatureCheckErrorDialog, 2131766392);
        setNegativeButton(this.mSignatureCheckErrorDialog, 2131768874);
      }
      localObject = this.mSignatureCheckErrorDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 6)
    {
      if (this.mDownloadErrorDialog == null)
      {
        this.mDownloadErrorDialog = buildAlertDialog();
        setTitle(this.mDownloadErrorDialog, 2131758230);
        setMessage(this.mDownloadErrorDialog, 2131758371);
        setPositiveButton(this.mDownloadErrorDialog, 2131768877);
        setNegativeButton(this.mDownloadErrorDialog, 2131768873);
      }
      localObject = this.mDownloadErrorDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 7)
    {
      if (this.mSelectStoreDialog == null)
      {
        this.mSelectStoreDialog = buildAlertDialog();
        setTitle(this.mSelectStoreDialog, 2131758230);
        setPositiveButton(this.mSelectStoreDialog, 2131768875);
      }
      localObject = this.mSelectStoreDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    if (paramInt == 8)
    {
      if (this.mUnsupportedStoreDialog == null)
      {
        this.mUnsupportedStoreDialog = buildAlertDialog();
        setTitle(this.mUnsupportedStoreDialog, 2131758230);
        setMessage(this.mUnsupportedStoreDialog, 2131766914);
        setNegativeButton(this.mUnsupportedStoreDialog, 2131768874);
      }
      localObject = this.mUnsupportedStoreDialog;
      AppMethodBeat.o(154697);
      return localObject;
    }
    Object localObject = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(154697);
    throw ((Throwable)localObject);
  }
  
  public ProgressDialog getProgressDialog(int paramInt)
  {
    AppMethodBeat.i(154698);
    if (paramInt == 11)
    {
      if (this.mDecompressingDialog == null)
      {
        this.mDecompressingDialog = buildProgressDialog();
        setTitle(this.mDecompressingDialog, 2131758230);
        setMessage(this.mDecompressingDialog, 2131758269);
        setNegativeButton(this.mDecompressingDialog, 2131768873);
        this.mDecompressingDialog.setProgressStyle(0);
      }
      localObject = this.mDecompressingDialog;
      AppMethodBeat.o(154698);
      return localObject;
    }
    if (paramInt == 12)
    {
      if (this.mDownloadingDialog == null)
      {
        this.mDownloadingDialog = buildProgressDialog();
        setTitle(this.mDownloadingDialog, 2131758230);
        setMessage(this.mDownloadingDialog, 2131758385);
        setNegativeButton(this.mDownloadingDialog, 2131768873);
        this.mDownloadingDialog.setProgressStyle(1);
      }
      localObject = this.mDownloadingDialog;
      AppMethodBeat.o(154698);
      return localObject;
    }
    Object localObject = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(154698);
    throw ((Throwable)localObject);
  }
  
  boolean isShowingDialog()
  {
    AppMethodBeat.i(154707);
    if ((this.mActiveDialog != null) && (this.mActiveDialog.isShowing()))
    {
      AppMethodBeat.o(154707);
      return true;
    }
    AppMethodBeat.o(154707);
    return false;
  }
  
  public void setAlertDialog(int paramInt, AlertDialog paramAlertDialog)
  {
    AppMethodBeat.i(154695);
    if (((paramAlertDialog instanceof ProgressDialog)) || ((paramAlertDialog instanceof DatePickerDialog)) || ((paramAlertDialog instanceof TimePickerDialog)))
    {
      paramAlertDialog = new IllegalArgumentException("The type of dialog must be AlertDialog");
      AppMethodBeat.o(154695);
      throw paramAlertDialog;
    }
    if (paramInt == 1)
    {
      this.mNotFoundDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 2)
    {
      this.mOlderVersionDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 3)
    {
      this.mNewerVersionDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 4)
    {
      this.mArchitectureMismatchDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 5)
    {
      this.mSignatureCheckErrorDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 6)
    {
      this.mDownloadErrorDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 7)
    {
      this.mSelectStoreDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    if (paramInt == 8)
    {
      this.mUnsupportedStoreDialog = paramAlertDialog;
      AppMethodBeat.o(154695);
      return;
    }
    paramAlertDialog = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(154695);
    throw paramAlertDialog;
  }
  
  void setProgress(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(154706);
    ProgressDialog localProgressDialog = (ProgressDialog)this.mActiveDialog;
    localProgressDialog.setIndeterminate(false);
    localProgressDialog.setMax(paramInt2);
    localProgressDialog.setProgress(paramInt1);
    AppMethodBeat.o(154706);
  }
  
  public void setProgressDialog(int paramInt, ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(154696);
    if (paramInt == 11)
    {
      this.mDecompressingDialog = paramProgressDialog;
      AppMethodBeat.o(154696);
      return;
    }
    if (paramInt == 12)
    {
      this.mDownloadingDialog = paramProgressDialog;
      AppMethodBeat.o(154696);
      return;
    }
    paramProgressDialog = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(154696);
    throw paramProgressDialog;
  }
  
  void showDecompressProgress(Runnable paramRunnable)
  {
    AppMethodBeat.i(154703);
    ProgressDialog localProgressDialog = getProgressDialog(11);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
    AppMethodBeat.o(154703);
  }
  
  void showDownloadError(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(154700);
    AlertDialog localAlertDialog = getAlertDialog(6);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ButtonAction(-1, paramRunnable2, true));
    localArrayList.add(new ButtonAction(-2, paramRunnable1, false));
    showDialog(localAlertDialog, localArrayList);
    AppMethodBeat.o(154700);
  }
  
  void showDownloadProgress(Runnable paramRunnable)
  {
    AppMethodBeat.i(154704);
    ProgressDialog localProgressDialog = getProgressDialog(12);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
    AppMethodBeat.o(154704);
  }
  
  void showInitializationError(int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(154699);
    ArrayList localArrayList = new ArrayList();
    AlertDialog localAlertDialog;
    if (paramInt == 2)
    {
      localAlertDialog = getAlertDialog(1);
      localArrayList.add(new ButtonAction(-1, paramRunnable2, true));
      localArrayList.add(new ButtonAction(-2, paramRunnable1, false));
      paramRunnable1 = localAlertDialog;
    }
    for (;;)
    {
      showDialog(paramRunnable1, localArrayList);
      AppMethodBeat.o(154699);
      return;
      if (paramInt == 3)
      {
        localAlertDialog = getAlertDialog(2);
        localArrayList.add(new ButtonAction(-1, paramRunnable2, true));
        localArrayList.add(new ButtonAction(-2, paramRunnable1, false));
        paramRunnable1 = localAlertDialog;
      }
      else if (paramInt == 4)
      {
        paramRunnable2 = getAlertDialog(3);
        localArrayList.add(new ButtonAction(-2, paramRunnable1, true));
        paramRunnable1 = paramRunnable2;
      }
      else if (paramInt == 6)
      {
        localAlertDialog = getAlertDialog(4);
        localArrayList.add(new ButtonAction(-1, paramRunnable2, true));
        localArrayList.add(new ButtonAction(-2, paramRunnable1, false));
        paramRunnable1 = localAlertDialog;
      }
      else
      {
        if (paramInt != 7) {
          break;
        }
        paramRunnable2 = getAlertDialog(5);
        localArrayList.add(new ButtonAction(-2, paramRunnable1, true));
        paramRunnable1 = paramRunnable2;
      }
    }
    paramRunnable1 = new IllegalArgumentException("Invalid status ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(154699);
    throw paramRunnable1;
  }
  
  void showSelectStore(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(154701);
    AlertDialog localAlertDialog = getAlertDialog(7);
    setMessage(localAlertDialog, this.mContext.getString(2131765168).replace("STORE_NAME", paramString));
    paramString = new ArrayList();
    paramString.add(new ButtonAction(-1, paramRunnable, true));
    showDialog(localAlertDialog, paramString);
    AppMethodBeat.o(154701);
  }
  
  void showUnsupportedStore(Runnable paramRunnable)
  {
    AppMethodBeat.i(154702);
    AlertDialog localAlertDialog = getAlertDialog(8);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ButtonAction(-2, paramRunnable, true));
    showDialog(localAlertDialog, localArrayList);
    AppMethodBeat.o(154702);
  }
  
  static class ButtonAction
  {
    Runnable mClickAction;
    boolean mMandatory;
    int mWhich;
    
    ButtonAction(int paramInt, Runnable paramRunnable, boolean paramBoolean)
    {
      this.mWhich = paramInt;
      this.mClickAction = paramRunnable;
      this.mMandatory = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager
 * JD-Core Version:    0.7.0.1
 */
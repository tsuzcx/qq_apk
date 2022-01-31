package org.xwalk.core;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

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
    AppMethodBeat.i(85617);
    AlertDialog localAlertDialog = new AlertDialog.Builder(this.mContext).create();
    localAlertDialog.setIcon(17301543);
    localAlertDialog.setCancelable(false);
    localAlertDialog.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(85617);
    return localAlertDialog;
  }
  
  private ProgressDialog buildProgressDialog()
  {
    AppMethodBeat.i(85618);
    ProgressDialog localProgressDialog = new ProgressDialog(this.mContext);
    localProgressDialog.setIndeterminate(true);
    localProgressDialog.setCancelable(false);
    localProgressDialog.setCanceledOnTouchOutside(false);
    AppMethodBeat.o(85618);
    return localProgressDialog;
  }
  
  private void setMessage(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(85620);
    setMessage(paramAlertDialog, this.mContext.getString(paramInt));
    AppMethodBeat.o(85620);
  }
  
  private void setMessage(AlertDialog paramAlertDialog, String paramString)
  {
    AppMethodBeat.i(85621);
    String str = paramString.replaceAll("APP_NAME", XWalkEnvironment.getApplicationName());
    paramString = str;
    if (str.startsWith("this")) {
      paramString = str.replaceFirst("this", "This");
    }
    paramAlertDialog.setMessage(paramString);
    AppMethodBeat.o(85621);
  }
  
  private void setNegativeButton(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(85623);
    paramAlertDialog.setButton(-2, this.mContext.getString(paramInt), null);
    AppMethodBeat.o(85623);
  }
  
  private void setPositiveButton(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(85622);
    paramAlertDialog.setButton(-1, this.mContext.getString(paramInt), null);
    AppMethodBeat.o(85622);
  }
  
  private void setTitle(AlertDialog paramAlertDialog, int paramInt)
  {
    AppMethodBeat.i(85619);
    paramAlertDialog.setTitle(this.mContext.getString(paramInt));
    AppMethodBeat.o(85619);
  }
  
  private void showDialog(AlertDialog paramAlertDialog, ArrayList<XWalkDialogManager.ButtonAction> paramArrayList)
  {
    AppMethodBeat.i(85624);
    paramAlertDialog.setOnShowListener(new XWalkDialogManager.1(this, paramArrayList, paramAlertDialog));
    this.mActiveDialog = paramAlertDialog;
    this.mActiveDialog.show();
    AppMethodBeat.o(85624);
  }
  
  void dismissDialog()
  {
    AppMethodBeat.i(85614);
    this.mActiveDialog.dismiss();
    this.mActiveDialog = null;
    AppMethodBeat.o(85614);
  }
  
  public AlertDialog getAlertDialog(int paramInt)
  {
    AppMethodBeat.i(85606);
    if (paramInt == 1)
    {
      if (this.mNotFoundDialog == null)
      {
        this.mNotFoundDialog = buildAlertDialog();
        setTitle(this.mNotFoundDialog, 2131306236);
        setMessage(this.mNotFoundDialog, 2131306235);
        setPositiveButton(this.mNotFoundDialog, 2131306276);
        setNegativeButton(this.mNotFoundDialog, 2131306274);
      }
      localObject = this.mNotFoundDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 2)
    {
      if (this.mOlderVersionDialog == null)
      {
        this.mOlderVersionDialog = buildAlertDialog();
        setTitle(this.mOlderVersionDialog, 2131306238);
        setMessage(this.mOlderVersionDialog, 2131306237);
        setPositiveButton(this.mOlderVersionDialog, 2131306276);
        setNegativeButton(this.mOlderVersionDialog, 2131306274);
      }
      localObject = this.mOlderVersionDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 3)
    {
      if (this.mNewerVersionDialog == null)
      {
        this.mNewerVersionDialog = buildAlertDialog();
        setTitle(this.mNewerVersionDialog, 2131306234);
        setMessage(this.mNewerVersionDialog, 2131306233);
        setNegativeButton(this.mNewerVersionDialog, 2131306274);
      }
      localObject = this.mNewerVersionDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 4)
    {
      if (this.mArchitectureMismatchDialog == null)
      {
        this.mArchitectureMismatchDialog = buildAlertDialog();
        setTitle(this.mArchitectureMismatchDialog, 2131306232);
        setMessage(this.mArchitectureMismatchDialog, 2131306231);
        setPositiveButton(this.mArchitectureMismatchDialog, 2131306276);
        setNegativeButton(this.mArchitectureMismatchDialog, 2131306274);
      }
      localObject = this.mArchitectureMismatchDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 5)
    {
      if (this.mSignatureCheckErrorDialog == null)
      {
        this.mSignatureCheckErrorDialog = buildAlertDialog();
        setTitle(this.mSignatureCheckErrorDialog, 2131306240);
        setMessage(this.mSignatureCheckErrorDialog, 2131306239);
        setNegativeButton(this.mSignatureCheckErrorDialog, 2131306274);
      }
      localObject = this.mSignatureCheckErrorDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 6)
    {
      if (this.mDownloadErrorDialog == null)
      {
        this.mDownloadErrorDialog = buildAlertDialog();
        setTitle(this.mDownloadErrorDialog, 2131306143);
        setMessage(this.mDownloadErrorDialog, 2131306153);
        setPositiveButton(this.mDownloadErrorDialog, 2131306277);
        setNegativeButton(this.mDownloadErrorDialog, 2131306273);
      }
      localObject = this.mDownloadErrorDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 7)
    {
      if (this.mSelectStoreDialog == null)
      {
        this.mSelectStoreDialog = buildAlertDialog();
        setTitle(this.mSelectStoreDialog, 2131306143);
        setPositiveButton(this.mSelectStoreDialog, 2131306275);
      }
      localObject = this.mSelectStoreDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    if (paramInt == 8)
    {
      if (this.mUnsupportedStoreDialog == null)
      {
        this.mUnsupportedStoreDialog = buildAlertDialog();
        setTitle(this.mUnsupportedStoreDialog, 2131306143);
        setMessage(this.mUnsupportedStoreDialog, 2131306243);
        setNegativeButton(this.mUnsupportedStoreDialog, 2131306274);
      }
      localObject = this.mUnsupportedStoreDialog;
      AppMethodBeat.o(85606);
      return localObject;
    }
    Object localObject = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(85606);
    throw ((Throwable)localObject);
  }
  
  public ProgressDialog getProgressDialog(int paramInt)
  {
    AppMethodBeat.i(85607);
    if (paramInt == 11)
    {
      if (this.mDecompressingDialog == null)
      {
        this.mDecompressingDialog = buildProgressDialog();
        setTitle(this.mDecompressingDialog, 2131306143);
        setMessage(this.mDecompressingDialog, 2131306144);
        setNegativeButton(this.mDecompressingDialog, 2131306273);
        this.mDecompressingDialog.setProgressStyle(0);
      }
      localObject = this.mDecompressingDialog;
      AppMethodBeat.o(85607);
      return localObject;
    }
    if (paramInt == 12)
    {
      if (this.mDownloadingDialog == null)
      {
        this.mDownloadingDialog = buildProgressDialog();
        setTitle(this.mDownloadingDialog, 2131306143);
        setMessage(this.mDownloadingDialog, 2131306154);
        setNegativeButton(this.mDownloadingDialog, 2131306273);
        this.mDownloadingDialog.setProgressStyle(1);
      }
      localObject = this.mDownloadingDialog;
      AppMethodBeat.o(85607);
      return localObject;
    }
    Object localObject = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(85607);
    throw ((Throwable)localObject);
  }
  
  boolean isShowingDialog()
  {
    AppMethodBeat.i(85616);
    if ((this.mActiveDialog != null) && (this.mActiveDialog.isShowing()))
    {
      AppMethodBeat.o(85616);
      return true;
    }
    AppMethodBeat.o(85616);
    return false;
  }
  
  public void setAlertDialog(int paramInt, AlertDialog paramAlertDialog)
  {
    AppMethodBeat.i(85604);
    if (((paramAlertDialog instanceof ProgressDialog)) || ((paramAlertDialog instanceof DatePickerDialog)) || ((paramAlertDialog instanceof TimePickerDialog)))
    {
      paramAlertDialog = new IllegalArgumentException("The type of dialog must be AlertDialog");
      AppMethodBeat.o(85604);
      throw paramAlertDialog;
    }
    if (paramInt == 1)
    {
      this.mNotFoundDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 2)
    {
      this.mOlderVersionDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 3)
    {
      this.mNewerVersionDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 4)
    {
      this.mArchitectureMismatchDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 5)
    {
      this.mSignatureCheckErrorDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 6)
    {
      this.mDownloadErrorDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 7)
    {
      this.mSelectStoreDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    if (paramInt == 8)
    {
      this.mUnsupportedStoreDialog = paramAlertDialog;
      AppMethodBeat.o(85604);
      return;
    }
    paramAlertDialog = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(85604);
    throw paramAlertDialog;
  }
  
  void setProgress(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(85615);
    ProgressDialog localProgressDialog = (ProgressDialog)this.mActiveDialog;
    localProgressDialog.setIndeterminate(false);
    localProgressDialog.setMax(paramInt2);
    localProgressDialog.setProgress(paramInt1);
    AppMethodBeat.o(85615);
  }
  
  public void setProgressDialog(int paramInt, ProgressDialog paramProgressDialog)
  {
    AppMethodBeat.i(85605);
    if (paramInt == 11)
    {
      this.mDecompressingDialog = paramProgressDialog;
      AppMethodBeat.o(85605);
      return;
    }
    if (paramInt == 12)
    {
      this.mDownloadingDialog = paramProgressDialog;
      AppMethodBeat.o(85605);
      return;
    }
    paramProgressDialog = new IllegalArgumentException("Invalid dialog id ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(85605);
    throw paramProgressDialog;
  }
  
  void showDecompressProgress(Runnable paramRunnable)
  {
    AppMethodBeat.i(85612);
    ProgressDialog localProgressDialog = getProgressDialog(11);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
    AppMethodBeat.o(85612);
  }
  
  void showDownloadError(Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(85609);
    AlertDialog localAlertDialog = getAlertDialog(6);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
    showDialog(localAlertDialog, localArrayList);
    AppMethodBeat.o(85609);
  }
  
  void showDownloadProgress(Runnable paramRunnable)
  {
    AppMethodBeat.i(85613);
    ProgressDialog localProgressDialog = getProgressDialog(12);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, false));
    showDialog(localProgressDialog, localArrayList);
    AppMethodBeat.o(85613);
  }
  
  void showInitializationError(int paramInt, Runnable paramRunnable1, Runnable paramRunnable2)
  {
    AppMethodBeat.i(85608);
    ArrayList localArrayList = new ArrayList();
    AlertDialog localAlertDialog;
    if (paramInt == 2)
    {
      localAlertDialog = getAlertDialog(1);
      localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
      localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
      paramRunnable1 = localAlertDialog;
    }
    for (;;)
    {
      showDialog(paramRunnable1, localArrayList);
      AppMethodBeat.o(85608);
      return;
      if (paramInt == 3)
      {
        localAlertDialog = getAlertDialog(2);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
        paramRunnable1 = localAlertDialog;
      }
      else if (paramInt == 4)
      {
        paramRunnable2 = getAlertDialog(3);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, true));
        paramRunnable1 = paramRunnable2;
      }
      else if (paramInt == 6)
      {
        localAlertDialog = getAlertDialog(4);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable2, true));
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, false));
        paramRunnable1 = localAlertDialog;
      }
      else
      {
        if (paramInt != 7) {
          break;
        }
        paramRunnable2 = getAlertDialog(5);
        localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable1, true));
        paramRunnable1 = paramRunnable2;
      }
    }
    paramRunnable1 = new IllegalArgumentException("Invalid status ".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(85608);
    throw paramRunnable1;
  }
  
  void showSelectStore(Runnable paramRunnable, String paramString)
  {
    AppMethodBeat.i(85610);
    AlertDialog localAlertDialog = getAlertDialog(7);
    setMessage(localAlertDialog, this.mContext.getString(2131306212).replace("STORE_NAME", paramString));
    paramString = new ArrayList();
    paramString.add(new XWalkDialogManager.ButtonAction(-1, paramRunnable, true));
    showDialog(localAlertDialog, paramString);
    AppMethodBeat.o(85610);
  }
  
  void showUnsupportedStore(Runnable paramRunnable)
  {
    AppMethodBeat.i(85611);
    AlertDialog localAlertDialog = getAlertDialog(8);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new XWalkDialogManager.ButtonAction(-2, paramRunnable, true));
    showDialog(localAlertDialog, localArrayList);
    AppMethodBeat.o(85611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager
 * JD-Core Version:    0.7.0.1
 */
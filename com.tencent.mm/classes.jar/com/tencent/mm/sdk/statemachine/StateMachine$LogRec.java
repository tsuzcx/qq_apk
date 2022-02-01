package com.tencent.mm.sdk.statemachine;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Calendar;

public class StateMachine$LogRec
{
  private IState mDstState;
  private String mInfo;
  private IState mOrgState;
  private StateMachine mSm;
  private IState mState;
  private long mTime;
  private int mWhat;
  
  StateMachine$LogRec(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    AppMethodBeat.i(158011);
    update(paramStateMachine, paramMessage, paramString, paramIState1, paramIState2, paramIState3);
    AppMethodBeat.o(158011);
  }
  
  public IState getDestState()
  {
    return this.mDstState;
  }
  
  public String getInfo()
  {
    return this.mInfo;
  }
  
  public IState getOriginalState()
  {
    return this.mOrgState;
  }
  
  public IState getState()
  {
    return this.mState;
  }
  
  public long getTime()
  {
    return this.mTime;
  }
  
  public long getWhat()
  {
    return this.mWhat;
  }
  
  public String toString()
  {
    AppMethodBeat.i(158013);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time=");
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(this.mTime);
    localStringBuilder.append(String.format("%tm-%td %tH:%tM:%tS.%tL", new Object[] { localObject, localObject, localObject, localObject, localObject, localObject }));
    localStringBuilder.append(" processed=");
    if (this.mState == null)
    {
      localObject = "<null>";
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" org=");
      if (this.mOrgState != null) {
        break label259;
      }
      localObject = "<null>";
      label111:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" dest=");
      if (this.mDstState != null) {
        break label272;
      }
      localObject = "<null>";
      label134:
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(" what=");
      if (this.mSm == null) {
        break label285;
      }
      localObject = this.mSm.getWhatToString(this.mWhat);
      label166:
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label291;
      }
      localStringBuilder.append(this.mWhat);
      localStringBuilder.append("(0x");
      localStringBuilder.append(Integer.toHexString(this.mWhat));
      localStringBuilder.append(")");
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.mInfo))
      {
        localStringBuilder.append(" ");
        localStringBuilder.append(this.mInfo);
      }
      localObject = localStringBuilder.toString();
      AppMethodBeat.o(158013);
      return localObject;
      localObject = this.mState.getName();
      break;
      label259:
      localObject = this.mOrgState.getName();
      break label111;
      label272:
      localObject = this.mDstState.getName();
      break label134;
      label285:
      localObject = "";
      break label166;
      label291:
      localStringBuilder.append((String)localObject);
    }
  }
  
  public void update(StateMachine paramStateMachine, Message paramMessage, String paramString, IState paramIState1, IState paramIState2, IState paramIState3)
  {
    AppMethodBeat.i(158012);
    this.mSm = paramStateMachine;
    this.mTime = System.currentTimeMillis();
    if (paramMessage != null) {}
    for (int i = paramMessage.what;; i = 0)
    {
      this.mWhat = i;
      this.mInfo = paramString;
      this.mState = paramIState1;
      this.mOrgState = paramIState2;
      this.mDstState = paramIState3;
      AppMethodBeat.o(158012);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.statemachine.StateMachine.LogRec
 * JD-Core Version:    0.7.0.1
 */
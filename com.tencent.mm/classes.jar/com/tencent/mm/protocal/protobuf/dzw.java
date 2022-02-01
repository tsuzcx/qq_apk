package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class dzw
  extends esc
{
  public b ZEQ;
  public LinkedList<bdm> ZJV;
  public int akkG;
  public boolean akkH;
  public boolean akkI;
  
  public dzw()
  {
    AppMethodBeat.i(369663);
    this.ZJV = new LinkedList();
    AppMethodBeat.o(369663);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369664);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "last_buffer", this.ZEQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "app_msg_list", this.ZJV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "next_interval_ms", Integer.valueOf(this.akkG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "has_new_msg", Boolean.valueOf(this.akkH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "need_clear_msg", Boolean.valueOf(this.akkI), false);
      label88:
      AppMethodBeat.o(369664);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label88;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369667);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      paramVarArgs.e(3, 8, this.ZJV);
      paramVarArgs.bS(4, this.akkG);
      paramVarArgs.di(5, this.akkH);
      paramVarArgs.di(6, this.akkI);
      AppMethodBeat.o(369667);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      paramInt = i.a.a.a.c(3, 8, this.ZJV);
      int j = i.a.a.b.b.a.cJ(4, this.akkG);
      int k = i.a.a.b.b.a.ko(5);
      int m = i.a.a.b.b.a.ko(6);
      AppMethodBeat.o(369667);
      return i + paramInt + j + (k + 1) + (m + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZJV.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(369667);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dzw localdzw = (dzw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(369667);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localdzw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369667);
          return 0;
        case 2: 
          localdzw.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(369667);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bdm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bdm)localObject2).parseFrom((byte[])localObject1);
            }
            localdzw.ZJV.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369667);
          return 0;
        case 4: 
          localdzw.akkG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(369667);
          return 0;
        case 5: 
          localdzw.akkH = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(369667);
          return 0;
        }
        localdzw.akkI = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(369667);
        return 0;
      }
      AppMethodBeat.o(369667);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzw
 * JD-Core Version:    0.7.0.1
 */
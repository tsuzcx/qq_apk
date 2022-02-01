package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class anc
  extends com.tencent.mm.bx.a
{
  public bfv Don;
  public b ZEQ;
  public long adlC;
  public LinkedList<anf> akjP;
  public long mMJ;
  
  public anc()
  {
    AppMethodBeat.i(369656);
    this.akjP = new LinkedList();
    AppMethodBeat.o(369656);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369657);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "boxId", this.Don, false);
      com.tencent.mm.bk.a.a(localJSONObject, "last_buffer", this.ZEQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "live_id", Long.valueOf(this.mMJ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "boxMsgs", this.akjP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "lastEnterTimeStamp", Long.valueOf(this.adlC), false);
      label74:
      AppMethodBeat.o(369657);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369658);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Don != null)
      {
        paramVarArgs.qD(1, this.Don.computeSize());
        this.Don.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      paramVarArgs.bv(3, this.mMJ);
      paramVarArgs.e(4, 8, this.akjP);
      paramVarArgs.bv(5, this.adlC);
      AppMethodBeat.o(369658);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Don == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.a.qC(1, this.Don.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      paramInt = i.a.a.b.b.a.q(3, this.mMJ);
      int j = i.a.a.a.c(4, 8, this.akjP);
      int k = i.a.a.b.b.a.q(5, this.adlC);
      AppMethodBeat.o(369658);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.akjP.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(369658);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        anc localanc = (anc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(369658);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bfv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bfv)localObject2).parseFrom((byte[])localObject1);
            }
            localanc.Don = ((bfv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369658);
          return 0;
        case 2: 
          localanc.ZEQ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(369658);
          return 0;
        case 3: 
          localanc.mMJ = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(369658);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new anf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((anf)localObject2).parseFrom((byte[])localObject1);
            }
            localanc.akjP.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(369658);
          return 0;
        }
        localanc.adlC = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(369658);
        return 0;
      }
      AppMethodBeat.o(369658);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anc
 * JD-Core Version:    0.7.0.1
 */
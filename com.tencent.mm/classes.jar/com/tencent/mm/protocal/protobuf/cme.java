package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cme
  extends cwj
{
  public String FJY;
  public String FJZ;
  public String HqZ;
  public String HxY;
  public String HxZ;
  public String Hya;
  public String Hyb;
  public String content;
  public boolean oGO;
  public String oGe;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lJ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FJY != null) {
        paramVarArgs.d(2, this.FJY);
      }
      if (this.FJZ != null) {
        paramVarArgs.d(3, this.FJZ);
      }
      paramVarArgs.aS(4, this.status);
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      if (this.oGe != null) {
        paramVarArgs.d(6, this.oGe);
      }
      if (this.HqZ != null) {
        paramVarArgs.d(7, this.HqZ);
      }
      paramVarArgs.bC(8, this.oGO);
      if (this.HxY != null) {
        paramVarArgs.d(9, this.HxY);
      }
      if (this.HxZ != null) {
        paramVarArgs.d(10, this.HxZ);
      }
      if (this.Hya != null) {
        paramVarArgs.d(11, this.Hya);
      }
      if (this.Hyb != null) {
        paramVarArgs.d(12, this.Hyb);
      }
      AppMethodBeat.o(114055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.a.lI(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FJY != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FJY);
      }
      i = paramInt;
      if (this.FJZ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FJZ);
      }
      i += f.a.a.b.b.a.bz(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt;
      if (this.oGe != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.oGe);
      }
      paramInt = i;
      if (this.HqZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.HqZ);
      }
      i = paramInt + f.a.a.b.b.a.amF(8);
      paramInt = i;
      if (this.HxY != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.HxY);
      }
      i = paramInt;
      if (this.HxZ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.HxZ);
      }
      paramInt = i;
      if (this.Hya != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.Hya);
      }
      i = paramInt;
      if (this.Hyb != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Hyb);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cwj.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cwj.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cme localcme = (cme)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cwj.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcme.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localcme.FJY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localcme.FJZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localcme.status = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localcme.content = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localcme.oGe = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localcme.HqZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localcme.oGO = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localcme.HxY = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localcme.HxZ = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localcme.Hya = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localcme.Hyb = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cme
 * JD-Core Version:    0.7.0.1
 */
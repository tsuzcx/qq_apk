package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcc
  extends cpx
{
  public String DLD;
  public String dbq;
  public String ddJ;
  public String sqm;
  public String sqn;
  public String sqo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32262);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dbq != null) {
        paramVarArgs.d(2, this.dbq);
      }
      if (this.sqm != null) {
        paramVarArgs.d(3, this.sqm);
      }
      if (this.sqn != null) {
        paramVarArgs.d(4, this.sqn);
      }
      if (this.sqo != null) {
        paramVarArgs.d(5, this.sqo);
      }
      if (this.ddJ != null) {
        paramVarArgs.d(6, this.ddJ);
      }
      if (this.DLD != null) {
        paramVarArgs.d(7, this.DLD);
      }
      AppMethodBeat.o(32262);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label687;
      }
    }
    label687:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dbq != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dbq);
      }
      i = paramInt;
      if (this.sqm != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sqm);
      }
      paramInt = i;
      if (this.sqn != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.sqn);
      }
      i = paramInt;
      if (this.sqo != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.sqo);
      }
      paramInt = i;
      if (this.ddJ != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.ddJ);
      }
      i = paramInt;
      if (this.DLD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DLD);
      }
      AppMethodBeat.o(32262);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32262);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bcc localbcc = (bcc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32262);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbcc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32262);
          return 0;
        case 2: 
          localbcc.dbq = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 3: 
          localbcc.sqm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 4: 
          localbcc.sqn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 5: 
          localbcc.sqo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32262);
          return 0;
        case 6: 
          localbcc.ddJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32262);
          return 0;
        }
        localbcc.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32262);
        return 0;
      }
      AppMethodBeat.o(32262);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcc
 * JD-Core Version:    0.7.0.1
 */
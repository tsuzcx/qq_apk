package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gag
  extends esc
{
  public long ZvA;
  public long abKe;
  public int abXJ;
  public int abXK;
  public int abXL;
  public int abXM;
  public com.tencent.mm.bx.b abXN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125510);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(125510);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.abKe);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bS(4, this.abXJ);
      paramVarArgs.bS(5, this.abXK);
      paramVarArgs.bS(6, this.abXL);
      paramVarArgs.bS(7, this.abXM);
      if (this.abXN != null) {
        paramVarArgs.d(8, this.abXN);
      }
      AppMethodBeat.o(125510);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label652;
      }
    }
    label652:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.abKe) + i.a.a.b.b.a.q(3, this.ZvA) + i.a.a.b.b.a.cJ(4, this.abXJ) + i.a.a.b.b.a.cJ(5, this.abXK) + i.a.a.b.b.a.cJ(6, this.abXL) + i.a.a.b.b.a.cJ(7, this.abXM);
      paramInt = i;
      if (this.abXN != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.abXN);
      }
      AppMethodBeat.o(125510);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(125510);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125510);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gag localgag = (gag)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125510);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localgag.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(125510);
          return 0;
        case 2: 
          localgag.abKe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125510);
          return 0;
        case 3: 
          localgag.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125510);
          return 0;
        case 4: 
          localgag.abXJ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125510);
          return 0;
        case 5: 
          localgag.abXK = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125510);
          return 0;
        case 6: 
          localgag.abXL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125510);
          return 0;
        case 7: 
          localgag.abXM = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(125510);
          return 0;
        }
        localgag.abXN = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(125510);
        return 0;
      }
      AppMethodBeat.o(125510);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gag
 * JD-Core Version:    0.7.0.1
 */
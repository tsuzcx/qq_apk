package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gnt
  extends erp
{
  public int IGW;
  public String YJV;
  public String aciJ;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152731);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.yts != null) {
        paramVarArgs.g(2, this.yts);
      }
      if (this.YJV != null) {
        paramVarArgs.g(3, this.YJV);
      }
      if (this.aciJ != null) {
        paramVarArgs.g(4, this.aciJ);
      }
      paramVarArgs.bS(5, this.IGW);
      AppMethodBeat.o(152731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label508;
      }
    }
    label508:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.yts);
      }
      i = paramInt;
      if (this.YJV != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YJV);
      }
      paramInt = i;
      if (this.aciJ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aciJ);
      }
      i = i.a.a.b.b.a.cJ(5, this.IGW);
      AppMethodBeat.o(152731);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gnt localgnt = (gnt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152731);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localgnt.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(152731);
          return 0;
        case 2: 
          localgnt.yts = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 3: 
          localgnt.YJV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 4: 
          localgnt.aciJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152731);
          return 0;
        }
        localgnt.IGW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(152731);
        return 0;
      }
      AppMethodBeat.o(152731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnt
 * JD-Core Version:    0.7.0.1
 */
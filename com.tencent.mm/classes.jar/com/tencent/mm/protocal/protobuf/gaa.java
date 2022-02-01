package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gaa
  extends erp
{
  public long ZvA;
  public long abKe;
  public long abmO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125502);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.abKe);
      paramVarArgs.bv(3, this.ZvA);
      paramVarArgs.bv(4, this.abmO);
      AppMethodBeat.o(125502);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label420;
      }
    }
    label420:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abKe);
      int j = i.a.a.b.b.a.q(3, this.ZvA);
      int k = i.a.a.b.b.a.q(4, this.abmO);
      AppMethodBeat.o(125502);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125502);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gaa localgaa = (gaa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125502);
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
            localgaa.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125502);
          return 0;
        case 2: 
          localgaa.abKe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125502);
          return 0;
        case 3: 
          localgaa.ZvA = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(125502);
          return 0;
        }
        localgaa.abmO = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(125502);
        return 0;
      }
      AppMethodBeat.o(125502);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gaa
 * JD-Core Version:    0.7.0.1
 */
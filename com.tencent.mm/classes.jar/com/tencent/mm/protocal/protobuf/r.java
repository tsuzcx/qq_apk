package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class r
  extends erp
{
  public long YAe;
  public String YAf;
  public String YzL;
  public String YzM;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91326);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YzL != null) {
        paramVarArgs.g(2, this.YzL);
      }
      paramVarArgs.bv(3, this.YAe);
      paramVarArgs.bS(4, this.scene);
      if (this.YzM != null) {
        paramVarArgs.g(5, this.YzM);
      }
      if (this.YAf != null) {
        paramVarArgs.g(6, this.YAf);
      }
      AppMethodBeat.o(91326);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label552;
      }
    }
    label552:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YzL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YzL);
      }
      i = i + i.a.a.b.b.a.q(3, this.YAe) + i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.YzM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YzM);
      }
      i = paramInt;
      if (this.YAf != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YAf);
      }
      AppMethodBeat.o(91326);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91326);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        r localr = (r)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91326);
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
            localr.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91326);
          return 0;
        case 2: 
          localr.YzL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91326);
          return 0;
        case 3: 
          localr.YAe = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(91326);
          return 0;
        case 4: 
          localr.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91326);
          return 0;
        case 5: 
          localr.YzM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91326);
          return 0;
        }
        localr.YAf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91326);
        return 0;
      }
      AppMethodBeat.o(91326);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.r
 * JD-Core Version:    0.7.0.1
 */
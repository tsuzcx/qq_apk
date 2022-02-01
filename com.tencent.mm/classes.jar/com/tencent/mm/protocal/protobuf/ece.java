package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ece
  extends erp
{
  public String YNW;
  public String ZiL;
  public String ZjI;
  public String ZjJ;
  public String ZjK;
  public String ZjL;
  public String oOI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91590);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOI != null) {
        paramVarArgs.g(2, this.oOI);
      }
      if (this.ZjI != null) {
        paramVarArgs.g(3, this.ZjI);
      }
      if (this.YNW != null) {
        paramVarArgs.g(4, this.YNW);
      }
      if (this.ZjJ != null) {
        paramVarArgs.g(5, this.ZjJ);
      }
      if (this.ZjK != null) {
        paramVarArgs.g(6, this.ZjK);
      }
      if (this.ZjL != null) {
        paramVarArgs.g(7, this.ZjL);
      }
      if (this.ZiL != null) {
        paramVarArgs.g(8, this.ZiL);
      }
      AppMethodBeat.o(91590);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label712;
      }
    }
    label712:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOI);
      }
      i = paramInt;
      if (this.ZjI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZjI);
      }
      paramInt = i;
      if (this.YNW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNW);
      }
      i = paramInt;
      if (this.ZjJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjJ);
      }
      paramInt = i;
      if (this.ZjK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjK);
      }
      i = paramInt;
      if (this.ZjL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjL);
      }
      paramInt = i;
      if (this.ZiL != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZiL);
      }
      AppMethodBeat.o(91590);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91590);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ece localece = (ece)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91590);
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
            localece.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91590);
          return 0;
        case 2: 
          localece.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 3: 
          localece.ZjI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 4: 
          localece.YNW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 5: 
          localece.ZjJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 6: 
          localece.ZjK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91590);
          return 0;
        case 7: 
          localece.ZjL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91590);
          return 0;
        }
        localece.ZiL = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91590);
        return 0;
      }
      AppMethodBeat.o(91590);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ece
 * JD-Core Version:    0.7.0.1
 */
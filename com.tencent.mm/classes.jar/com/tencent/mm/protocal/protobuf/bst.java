package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bst
  extends esc
{
  public String Vpy;
  public int ZND;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259732);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Vpy != null) {
        paramVarArgs.g(2, this.Vpy);
      }
      paramVarArgs.bS(3, this.ZND);
      AppMethodBeat.o(259732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Vpy != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.Vpy);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZND);
      AppMethodBeat.o(259732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bst localbst = (bst)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259732);
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
            localbst.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(259732);
          return 0;
        case 2: 
          localbst.Vpy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259732);
          return 0;
        }
        localbst.ZND = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259732);
        return 0;
      }
      AppMethodBeat.o(259732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bst
 * JD-Core Version:    0.7.0.1
 */
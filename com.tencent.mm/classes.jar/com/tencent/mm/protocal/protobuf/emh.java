package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class emh
  extends erp
{
  public String VCP;
  public String VJo;
  public String VxX;
  public String hMy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(174534);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hMy != null) {
        paramVarArgs.g(2, this.hMy);
      }
      if (this.VxX != null) {
        paramVarArgs.g(3, this.VxX);
      }
      if (this.VCP != null) {
        paramVarArgs.g(4, this.VCP);
      }
      if (this.VJo != null) {
        paramVarArgs.g(5, this.VJo);
      }
      AppMethodBeat.o(174534);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label524;
      }
    }
    label524:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hMy != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hMy);
      }
      i = paramInt;
      if (this.VxX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.VxX);
      }
      paramInt = i;
      if (this.VCP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.VCP);
      }
      i = paramInt;
      if (this.VJo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.VJo);
      }
      AppMethodBeat.o(174534);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(174534);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        emh localemh = (emh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(174534);
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
            localemh.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(174534);
          return 0;
        case 2: 
          localemh.hMy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 3: 
          localemh.VxX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(174534);
          return 0;
        case 4: 
          localemh.VCP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(174534);
          return 0;
        }
        localemh.VJo = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(174534);
        return 0;
      }
      AppMethodBeat.o(174534);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emh
 * JD-Core Version:    0.7.0.1
 */
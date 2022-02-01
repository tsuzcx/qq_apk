package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yz
  extends erp
{
  public String YEb;
  public String ZhB;
  public boolean ZhC;
  public int ZhD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125716);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YEb != null) {
        paramVarArgs.g(2, this.YEb);
      }
      if (this.ZhB != null) {
        paramVarArgs.g(3, this.ZhB);
      }
      paramVarArgs.di(4, this.ZhC);
      paramVarArgs.bS(5, this.ZhD);
      AppMethodBeat.o(125716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YEb != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YEb);
      }
      i = paramInt;
      if (this.ZhB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZhB);
      }
      paramInt = i.a.a.b.b.a.ko(4);
      int j = i.a.a.b.b.a.cJ(5, this.ZhD);
      AppMethodBeat.o(125716);
      return i + (paramInt + 1) + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        yz localyz = (yz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125716);
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
            localyz.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(125716);
          return 0;
        case 2: 
          localyz.YEb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 3: 
          localyz.ZhB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125716);
          return 0;
        case 4: 
          localyz.ZhC = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(125716);
          return 0;
        }
        localyz.ZhD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(125716);
        return 0;
      }
      AppMethodBeat.o(125716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yz
 * JD-Core Version:    0.7.0.1
 */
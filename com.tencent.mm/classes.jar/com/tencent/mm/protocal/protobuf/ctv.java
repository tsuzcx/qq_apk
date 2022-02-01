package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ctv
  extends erp
{
  public LinkedList<fqj> aazx;
  public String aazy;
  public int vgM;
  
  public ctv()
  {
    AppMethodBeat.i(152600);
    this.aazx = new LinkedList();
    AppMethodBeat.o(152600);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152601);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vgM);
      paramVarArgs.e(3, 8, this.aazx);
      if (this.aazy != null) {
        paramVarArgs.g(4, this.aazy);
      }
      AppMethodBeat.o(152601);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label506;
      }
    }
    label506:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vgM) + i.a.a.a.c(3, 8, this.aazx);
      paramInt = i;
      if (this.aazy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aazy);
      }
      AppMethodBeat.o(152601);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aazx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152601);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ctv localctv = (ctv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152601);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localctv.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152601);
          return 0;
        case 2: 
          localctv.vgM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152601);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fqj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fqj)localObject2).parseFrom((byte[])localObject1);
            }
            localctv.aazx.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152601);
          return 0;
        }
        localctv.aazy = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(152601);
        return 0;
      }
      AppMethodBeat.o(152601);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctv
 * JD-Core Version:    0.7.0.1
 */
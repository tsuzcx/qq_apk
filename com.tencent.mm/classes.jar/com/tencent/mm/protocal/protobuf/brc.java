package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class brc
  extends cvc
{
  public String GLA;
  public LinkedList<String> GLo;
  public int GLp;
  public int GLq;
  public egx GLr;
  public int GLz;
  public String iht;
  
  public brc()
  {
    AppMethodBeat.i(123611);
    this.GLo = new LinkedList();
    AppMethodBeat.o(123611);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iht != null) {
        paramVarArgs.d(2, this.iht);
      }
      paramVarArgs.e(3, 1, this.GLo);
      paramVarArgs.aS(4, this.GLz);
      if (this.GLA != null) {
        paramVarArgs.d(6, this.GLA);
      }
      paramVarArgs.aS(7, this.GLp);
      paramVarArgs.aS(8, this.GLq);
      if (this.GLr != null)
      {
        paramVarArgs.lC(9, this.GLr.computeSize());
        this.GLr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.iht != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.iht);
      }
      i = i + f.a.a.a.c(3, 1, this.GLo) + f.a.a.b.b.a.bz(4, this.GLz);
      paramInt = i;
      if (this.GLA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GLA);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.GLp) + f.a.a.b.b.a.bz(8, this.GLq);
      paramInt = i;
      if (this.GLr != null) {
        paramInt = i + f.a.a.a.lB(9, this.GLr.computeSize());
      }
      AppMethodBeat.o(123612);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLo.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        brc localbrc = (brc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        default: 
          AppMethodBeat.o(123612);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbrc.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123612);
          return 0;
        case 2: 
          localbrc.iht = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 3: 
          localbrc.GLo.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(123612);
          return 0;
        case 4: 
          localbrc.GLz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123612);
          return 0;
        case 6: 
          localbrc.GLA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123612);
          return 0;
        case 7: 
          localbrc.GLp = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123612);
          return 0;
        case 8: 
          localbrc.GLq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(123612);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new egx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((egx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbrc.GLr = ((egx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123612);
        return 0;
      }
      AppMethodBeat.o(123612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.brc
 * JD-Core Version:    0.7.0.1
 */
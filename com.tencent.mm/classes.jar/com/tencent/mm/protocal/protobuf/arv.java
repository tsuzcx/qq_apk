package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arv
  extends cvc
{
  public alk Glv;
  public LinkedList<FinderContact> Gne;
  public LinkedList<FinderContact> GoJ;
  public SKBuiltinBuffer_t Gqg;
  public int duf;
  public String rTn;
  
  public arv()
  {
    AppMethodBeat.i(169060);
    this.Gne = new LinkedList();
    this.GoJ = new LinkedList();
    AppMethodBeat.o(169060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169061);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.duf);
      if (this.Gqg != null)
      {
        paramVarArgs.lC(3, this.Gqg.computeSize());
        this.Gqg.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.Gne);
      paramVarArgs.e(5, 8, this.GoJ);
      if (this.rTn != null) {
        paramVarArgs.d(6, this.rTn);
      }
      if (this.Glv != null)
      {
        paramVarArgs.lC(7, this.Glv.computeSize());
        this.Glv.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1006;
      }
    }
    label1006:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.duf);
      paramInt = i;
      if (this.Gqg != null) {
        paramInt = i + f.a.a.a.lB(3, this.Gqg.computeSize());
      }
      i = paramInt + f.a.a.a.c(4, 8, this.Gne) + f.a.a.a.c(5, 8, this.GoJ);
      paramInt = i;
      if (this.rTn != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.rTn);
      }
      i = paramInt;
      if (this.Glv != null) {
        i = paramInt + f.a.a.a.lB(7, this.Glv.computeSize());
      }
      AppMethodBeat.o(169061);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gne.clear();
        this.GoJ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arv localarv = (arv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169061);
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
            localarv.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 2: 
          localarv.duf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(169061);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.Gqg = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.Gne.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.GoJ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 6: 
          localarv.rTn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(169061);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarv.Glv = ((alk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      AppMethodBeat.o(169061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arv
 * JD-Core Version:    0.7.0.1
 */
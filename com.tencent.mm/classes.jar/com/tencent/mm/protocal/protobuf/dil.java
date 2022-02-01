package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dil
  extends cvc
{
  public String Fwt;
  public int Hxm;
  public int Hxn;
  public LinkedList<din> Hxo;
  public dik Hxp;
  public int Hxq;
  public LinkedList<dik> Hxr;
  public String uki;
  public String ukj;
  
  public dil()
  {
    AppMethodBeat.i(152697);
    this.Hxo = new LinkedList();
    this.Hxr = new LinkedList();
    AppMethodBeat.o(152697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Hxm);
      if (this.ukj != null) {
        paramVarArgs.d(3, this.ukj);
      }
      if (this.uki != null) {
        paramVarArgs.d(4, this.uki);
      }
      if (this.Fwt != null) {
        paramVarArgs.d(5, this.Fwt);
      }
      paramVarArgs.aS(6, this.Hxn);
      paramVarArgs.e(7, 8, this.Hxo);
      if (this.Hxp != null)
      {
        paramVarArgs.lC(8, this.Hxp.computeSize());
        this.Hxp.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.Hxq);
      paramVarArgs.e(10, 8, this.Hxr);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.Hxm);
      paramInt = i;
      if (this.ukj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.ukj);
      }
      i = paramInt;
      if (this.uki != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uki);
      }
      paramInt = i;
      if (this.Fwt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Fwt);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.Hxn) + f.a.a.a.c(7, 8, this.Hxo);
      paramInt = i;
      if (this.Hxp != null) {
        paramInt = i + f.a.a.a.lB(8, this.Hxp.computeSize());
      }
      i = f.a.a.b.b.a.bz(9, this.Hxq);
      int j = f.a.a.a.c(10, 8, this.Hxr);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Hxo.clear();
        this.Hxr.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dil localdil = (dil)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
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
            localdil.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localdil.Hxm = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localdil.ukj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localdil.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localdil.Fwt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localdil.Hxn = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new din();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((din)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdil.Hxo.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dik();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdil.Hxp = ((dik)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localdil.Hxq = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dik();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dik)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdil.Hxr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      AppMethodBeat.o(152698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dil
 * JD-Core Version:    0.7.0.1
 */
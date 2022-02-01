package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajs
  extends com.tencent.mm.bx.a
{
  public String Gjg;
  public LinkedList<String> Gjh;
  public String appId;
  public akd dEQ;
  public String desc;
  public String djX;
  public String dyU;
  public String title;
  public int type;
  
  public ajs()
  {
    AppMethodBeat.i(127463);
    this.Gjh = new LinkedList();
    AppMethodBeat.o(127463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127464);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      if (this.dyU != null) {
        paramVarArgs.d(3, this.dyU);
      }
      if (this.Gjg != null) {
        paramVarArgs.d(4, this.Gjg);
      }
      if (this.appId != null) {
        paramVarArgs.d(5, this.appId);
      }
      if (this.djX != null) {
        paramVarArgs.d(6, this.djX);
      }
      paramVarArgs.e(7, 1, this.Gjh);
      paramVarArgs.aS(8, this.type);
      if (this.dEQ != null)
      {
        paramVarArgs.lC(9, this.dEQ.computeSize());
        this.dEQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.desc);
      }
      i = paramInt;
      if (this.dyU != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dyU);
      }
      paramInt = i;
      if (this.Gjg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gjg);
      }
      i = paramInt;
      if (this.appId != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.appId);
      }
      paramInt = i;
      if (this.djX != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.djX);
      }
      i = paramInt + f.a.a.a.c(7, 1, this.Gjh) + f.a.a.b.b.a.bz(8, this.type);
      paramInt = i;
      if (this.dEQ != null) {
        paramInt = i + f.a.a.a.lB(9, this.dEQ.computeSize());
      }
      AppMethodBeat.o(127464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gjh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajs localajs = (ajs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127464);
          return -1;
        case 1: 
          localajs.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 2: 
          localajs.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 3: 
          localajs.dyU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 4: 
          localajs.Gjg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 5: 
          localajs.appId = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 6: 
          localajs.djX = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(127464);
          return 0;
        case 7: 
          localajs.Gjh.add(((f.a.a.a.a)localObject1).NPN.readString());
          AppMethodBeat.o(127464);
          return 0;
        case 8: 
          localajs.type = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(127464);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((akd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localajs.dEQ = ((akd)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127464);
        return 0;
      }
      AppMethodBeat.o(127464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajs
 * JD-Core Version:    0.7.0.1
 */
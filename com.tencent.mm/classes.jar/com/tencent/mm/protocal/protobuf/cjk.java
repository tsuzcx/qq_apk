package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjk
  extends com.tencent.mm.bx.a
{
  public String CNU;
  public String CzQ;
  public String CzR;
  public csg Hdq;
  public String desc;
  public String hzB;
  public String name;
  public String title;
  public int uxt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      if (this.title != null) {
        paramVarArgs.d(2, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      if (this.hzB != null) {
        paramVarArgs.d(4, this.hzB);
      }
      paramVarArgs.aS(5, this.uxt);
      if (this.CNU != null) {
        paramVarArgs.d(6, this.CNU);
      }
      if (this.CzQ != null) {
        paramVarArgs.d(7, this.CzQ);
      }
      if (this.CzR != null) {
        paramVarArgs.d(8, this.CzR);
      }
      if (this.Hdq != null)
      {
        paramVarArgs.lC(9, this.Hdq.computeSize());
        this.Hdq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72542);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label782;
      }
    }
    label782:
    for (int i = f.a.a.b.b.a.e(1, this.name) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.title);
      }
      i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.desc);
      }
      paramInt = i;
      if (this.hzB != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.hzB);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.uxt);
      paramInt = i;
      if (this.CNU != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CNU);
      }
      i = paramInt;
      if (this.CzQ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.CzQ);
      }
      paramInt = i;
      if (this.CzR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CzR);
      }
      i = paramInt;
      if (this.Hdq != null) {
        i = paramInt + f.a.a.a.lB(9, this.Hdq.computeSize());
      }
      AppMethodBeat.o(72542);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjk localcjk = (cjk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72542);
          return -1;
        case 1: 
          localcjk.name = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 2: 
          localcjk.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 3: 
          localcjk.desc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 4: 
          localcjk.hzB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 5: 
          localcjk.uxt = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72542);
          return 0;
        case 6: 
          localcjk.CNU = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 7: 
          localcjk.CzQ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        case 8: 
          localcjk.CzR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72542);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new csg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((csg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjk.Hdq = ((csg)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72542);
        return 0;
      }
      AppMethodBeat.o(72542);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjk
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dic
  extends com.tencent.mm.bx.a
{
  public String GIA;
  public String GIB;
  public dno GIy;
  public dno GIz;
  public String Grw;
  public String Gry;
  public boolean Grz = false;
  public int flags;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122550);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GIy != null)
      {
        paramVarArgs.lC(1, this.GIy.computeSize());
        this.GIy.writeFields(paramVarArgs);
      }
      if (this.GIz != null)
      {
        paramVarArgs.lC(2, this.GIz.computeSize());
        this.GIz.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(3, this.Grz);
      if (this.Grw != null) {
        paramVarArgs.d(4, this.Grw);
      }
      paramVarArgs.aS(5, this.flags);
      if (this.Gry != null) {
        paramVarArgs.d(6, this.Gry);
      }
      if (this.GIA != null) {
        paramVarArgs.d(7, this.GIA);
      }
      if (this.GIB != null) {
        paramVarArgs.d(8, this.GIB);
      }
      paramVarArgs.aY(9, this.timestamp);
      AppMethodBeat.o(122550);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GIy == null) {
        break label842;
      }
    }
    label842:
    for (paramInt = f.a.a.a.lB(1, this.GIy.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GIz != null) {
        i = paramInt + f.a.a.a.lB(2, this.GIz.computeSize());
      }
      i += f.a.a.b.b.a.alV(3);
      paramInt = i;
      if (this.Grw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Grw);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.flags);
      paramInt = i;
      if (this.Gry != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Gry);
      }
      i = paramInt;
      if (this.GIA != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GIA);
      }
      paramInt = i;
      if (this.GIB != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GIB);
      }
      i = f.a.a.b.b.a.p(9, this.timestamp);
      AppMethodBeat.o(122550);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(122550);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dic localdic = (dic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122550);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdic.GIy = ((dno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dno();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdic.GIz = ((dno)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122550);
          return 0;
        case 3: 
          localdic.Grz = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(122550);
          return 0;
        case 4: 
          localdic.Grw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 5: 
          localdic.flags = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(122550);
          return 0;
        case 6: 
          localdic.Gry = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 7: 
          localdic.GIA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122550);
          return 0;
        case 8: 
          localdic.GIB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(122550);
          return 0;
        }
        localdic.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(122550);
        return 0;
      }
      AppMethodBeat.o(122550);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dic
 * JD-Core Version:    0.7.0.1
 */
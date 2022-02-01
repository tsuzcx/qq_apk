package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnz
  extends com.tencent.mm.bx.a
{
  public String GIA;
  public String GIB;
  public boolean GIC = false;
  public boolean GID;
  public bod GIE;
  public dwc GIF;
  public bch GIG;
  public dno GIy;
  public dno GIz;
  public boolean GrA = false;
  public String Grw;
  public int Grx;
  public String Gry;
  public boolean Grz = false;
  public int flags;
  public int msgType = -1;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122507);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.msgType);
      if (this.GIy != null)
      {
        paramVarArgs.lC(2, this.GIy.computeSize());
        this.GIy.writeFields(paramVarArgs);
      }
      if (this.GIz != null)
      {
        paramVarArgs.lC(3, this.GIz.computeSize());
        this.GIz.writeFields(paramVarArgs);
      }
      paramVarArgs.bt(4, this.Grz);
      if (this.Grw != null) {
        paramVarArgs.d(5, this.Grw);
      }
      paramVarArgs.aS(6, this.flags);
      if (this.Gry != null) {
        paramVarArgs.d(7, this.Gry);
      }
      if (this.GIA != null) {
        paramVarArgs.d(8, this.GIA);
      }
      if (this.GIB != null) {
        paramVarArgs.d(9, this.GIB);
      }
      paramVarArgs.bt(10, this.GIC);
      paramVarArgs.bt(11, this.GID);
      paramVarArgs.bt(12, this.GrA);
      if (this.GIE != null)
      {
        paramVarArgs.lC(13, this.GIE.computeSize());
        this.GIE.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(14, this.timestamp);
      if (this.GIF != null)
      {
        paramVarArgs.lC(15, this.GIF.computeSize());
        this.GIF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(16, this.Grx);
      if (this.GIG != null)
      {
        paramVarArgs.lC(17, this.GIG.computeSize());
        this.GIG.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.msgType) + 0;
      paramInt = i;
      if (this.GIy != null) {
        paramInt = i + f.a.a.a.lB(2, this.GIy.computeSize());
      }
      i = paramInt;
      if (this.GIz != null) {
        i = paramInt + f.a.a.a.lB(3, this.GIz.computeSize());
      }
      i += f.a.a.b.b.a.alV(4);
      paramInt = i;
      if (this.Grw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Grw);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.flags);
      paramInt = i;
      if (this.Gry != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Gry);
      }
      i = paramInt;
      if (this.GIA != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.GIA);
      }
      paramInt = i;
      if (this.GIB != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.GIB);
      }
      i = paramInt + f.a.a.b.b.a.alV(10) + f.a.a.b.b.a.alV(11) + f.a.a.b.b.a.alV(12);
      paramInt = i;
      if (this.GIE != null) {
        paramInt = i + f.a.a.a.lB(13, this.GIE.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.p(14, this.timestamp);
      paramInt = i;
      if (this.GIF != null) {
        paramInt = i + f.a.a.a.lB(15, this.GIF.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(16, this.Grx);
      paramInt = i;
      if (this.GIG != null) {
        paramInt = i + f.a.a.a.lB(17, this.GIG.computeSize());
      }
      AppMethodBeat.o(122507);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bnz localbnz = (bnz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122507);
        return -1;
      case 1: 
        localbnz.msgType = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122507);
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
          localbnz.GIy = ((dno)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dno();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dno)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnz.GIz = ((dno)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 4: 
        localbnz.Grz = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122507);
        return 0;
      case 5: 
        localbnz.Grw = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 6: 
        localbnz.flags = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122507);
        return 0;
      case 7: 
        localbnz.Gry = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 8: 
        localbnz.GIA = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 9: 
        localbnz.GIB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(122507);
        return 0;
      case 10: 
        localbnz.GIC = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122507);
        return 0;
      case 11: 
        localbnz.GID = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122507);
        return 0;
      case 12: 
        localbnz.GrA = ((f.a.a.a.a)localObject1).NPN.grw();
        AppMethodBeat.o(122507);
        return 0;
      case 13: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bod();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bod)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnz.GIE = ((bod)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 14: 
        localbnz.timestamp = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(122507);
        return 0;
      case 15: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbnz.GIF = ((dwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122507);
        return 0;
      case 16: 
        localbnz.Grx = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(122507);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bch();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bch)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localbnz.GIG = ((bch)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122507);
      return 0;
    }
    AppMethodBeat.o(122507);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnz
 * JD-Core Version:    0.7.0.1
 */
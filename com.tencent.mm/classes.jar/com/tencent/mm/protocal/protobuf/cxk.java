package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxk
  extends com.tencent.mm.bw.a
{
  public LinkedList<afc> Guu;
  public dny HHW;
  public afb HHX;
  public int HHY;
  public boolean HHZ;
  public acn HIa;
  public bf HIb;
  public int type;
  public String url;
  
  public cxk()
  {
    AppMethodBeat.i(91676);
    this.Guu = new LinkedList();
    AppMethodBeat.o(91676);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91677);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.type);
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.HHW != null)
      {
        paramVarArgs.lJ(3, this.HHW.computeSize());
        this.HHW.writeFields(paramVarArgs);
      }
      if (this.HHX != null)
      {
        paramVarArgs.lJ(4, this.HHX.computeSize());
        this.HHX.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.HHY);
      paramVarArgs.bC(6, this.HHZ);
      paramVarArgs.e(7, 8, this.Guu);
      if (this.HIa != null)
      {
        paramVarArgs.lJ(8, this.HIa.computeSize());
        this.HIa.writeFields(paramVarArgs);
      }
      if (this.HIb != null)
      {
        paramVarArgs.lJ(9, this.HIb.computeSize());
        this.HIb.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.type) + 0;
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.HHW != null) {
        i = paramInt + f.a.a.a.lI(3, this.HHW.computeSize());
      }
      paramInt = i;
      if (this.HHX != null) {
        paramInt = i + f.a.a.a.lI(4, this.HHX.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.HHY) + f.a.a.b.b.a.amF(6) + f.a.a.a.c(7, 8, this.Guu);
      paramInt = i;
      if (this.HIa != null) {
        paramInt = i + f.a.a.a.lI(8, this.HIa.computeSize());
      }
      i = paramInt;
      if (this.HIb != null) {
        i = paramInt + f.a.a.a.lI(9, this.HIb.computeSize());
      }
      AppMethodBeat.o(91677);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Guu.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cxk localcxk = (cxk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91677);
        return -1;
      case 1: 
        localcxk.type = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91677);
        return 0;
      case 2: 
        localcxk.url = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91677);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dny();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dny)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.HHW = ((dny)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.HHX = ((afb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 5: 
        localcxk.HHY = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91677);
        return 0;
      case 6: 
        localcxk.HHZ = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(91677);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new afc();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((afc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.Guu.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      case 8: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxk.HIa = ((acn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91677);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new bf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((bf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcxk.HIb = ((bf)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91677);
      return 0;
    }
    AppMethodBeat.o(91677);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxk
 * JD-Core Version:    0.7.0.1
 */
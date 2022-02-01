package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ava
  extends com.tencent.mm.bw.a
{
  public LinkedList<auu> GLZ;
  public LinkedList<avc> GMa;
  public String GMb;
  public String GMc;
  public LinkedList<avb> GMd;
  public int GMe;
  public boolean GMf;
  public String Title;
  public int type;
  
  public ava()
  {
    AppMethodBeat.i(42642);
    this.GLZ = new LinkedList();
    this.GMa = new LinkedList();
    this.GMd = new LinkedList();
    AppMethodBeat.o(42642);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(42643);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.aS(2, this.type);
      paramVarArgs.e(3, 8, this.GLZ);
      paramVarArgs.e(4, 8, this.GMa);
      if (this.GMb != null) {
        paramVarArgs.d(5, this.GMb);
      }
      if (this.GMc != null) {
        paramVarArgs.d(6, this.GMc);
      }
      paramVarArgs.e(7, 8, this.GMd);
      paramVarArgs.aS(8, this.GMe);
      paramVarArgs.bC(9, this.GMf);
      AppMethodBeat.o(42643);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type) + f.a.a.a.c(3, 8, this.GLZ) + f.a.a.a.c(4, 8, this.GMa);
      paramInt = i;
      if (this.GMb != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GMb);
      }
      i = paramInt;
      if (this.GMc != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.GMc);
      }
      paramInt = f.a.a.a.c(7, 8, this.GMd);
      int j = f.a.a.b.b.a.bz(8, this.GMe);
      int k = f.a.a.b.b.a.amF(9);
      AppMethodBeat.o(42643);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLZ.clear();
        this.GMa.clear();
        this.GMd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(42643);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ava localava = (ava)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(42643);
          return -1;
        case 1: 
          localava.Title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 2: 
          localava.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(42643);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new auu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((auu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localava.GLZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localava.GMa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 5: 
          localava.GMb = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 6: 
          localava.GMc = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(42643);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new avb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((avb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localava.GMd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(42643);
          return 0;
        case 8: 
          localava.GMe = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(42643);
          return 0;
        }
        localava.GMf = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(42643);
        return 0;
      }
      AppMethodBeat.o(42643);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ava
 * JD-Core Version:    0.7.0.1
 */
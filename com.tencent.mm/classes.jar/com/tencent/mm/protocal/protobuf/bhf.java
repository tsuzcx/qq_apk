package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bhf
  extends dop
{
  public int KJS;
  public int KMd;
  public int KOL;
  public int LRd;
  public String LRe;
  public LinkedList<bhe> LRf;
  public LinkedList<b> LRg;
  public int Scene;
  public String pLm;
  
  public bhf()
  {
    AppMethodBeat.i(152547);
    this.LRf = new LinkedList();
    this.LRg = new LinkedList();
    AppMethodBeat.o(152547);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152548);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.KOL);
      paramVarArgs.aM(3, this.Scene);
      paramVarArgs.aM(4, this.KMd);
      paramVarArgs.aM(5, this.LRd);
      if (this.pLm != null) {
        paramVarArgs.e(6, this.pLm);
      }
      if (this.LRe != null) {
        paramVarArgs.e(7, this.LRe);
      }
      paramVarArgs.aM(8, this.KJS);
      paramVarArgs.e(9, 8, this.LRf);
      paramVarArgs.e(10, 6, this.LRg);
      AppMethodBeat.o(152548);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.KOL) + g.a.a.b.b.a.bu(3, this.Scene) + g.a.a.b.b.a.bu(4, this.KMd) + g.a.a.b.b.a.bu(5, this.LRd);
      paramInt = i;
      if (this.pLm != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.pLm);
      }
      i = paramInt;
      if (this.LRe != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.LRe);
      }
      paramInt = g.a.a.b.b.a.bu(8, this.KJS);
      int j = g.a.a.a.c(9, 8, this.LRf);
      int k = g.a.a.a.c(10, 6, this.LRg);
      AppMethodBeat.o(152548);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LRf.clear();
        this.LRg.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152548);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bhf localbhf = (bhf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152548);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        case 2: 
          localbhf.KOL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152548);
          return 0;
        case 3: 
          localbhf.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152548);
          return 0;
        case 4: 
          localbhf.KMd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152548);
          return 0;
        case 5: 
          localbhf.LRd = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152548);
          return 0;
        case 6: 
          localbhf.pLm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 7: 
          localbhf.LRe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152548);
          return 0;
        case 8: 
          localbhf.KJS = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(152548);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bhe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bhe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbhf.LRf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152548);
          return 0;
        }
        localbhf.LRg.add(((g.a.a.a.a)localObject1).UbS.hPo());
        AppMethodBeat.o(152548);
        return 0;
      }
      AppMethodBeat.o(152548);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhf
 * JD-Core Version:    0.7.0.1
 */
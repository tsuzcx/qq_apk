package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vz
  extends buy
{
  public String Name;
  public int jJu;
  public String wOC;
  public String wOD;
  public azt wOE;
  public LinkedList<bwc> wOF;
  public String wOG;
  public String wOH;
  
  public vz()
  {
    AppMethodBeat.i(28377);
    this.wOF = new LinkedList();
    AppMethodBeat.o(28377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28378);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Loc");
        AppMethodBeat.o(28378);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Name != null) {
        paramVarArgs.e(2, this.Name);
      }
      if (this.wOC != null) {
        paramVarArgs.e(3, this.wOC);
      }
      if (this.wOD != null) {
        paramVarArgs.e(4, this.wOD);
      }
      if (this.wOE != null)
      {
        paramVarArgs.iQ(5, this.wOE.computeSize());
        this.wOE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.jJu);
      paramVarArgs.e(7, 8, this.wOF);
      if (this.wOG != null) {
        paramVarArgs.e(8, this.wOG);
      }
      if (this.wOH != null) {
        paramVarArgs.e(9, this.wOH);
      }
      AppMethodBeat.o(28378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1021;
      }
    }
    label1021:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Name);
      }
      i = paramInt;
      if (this.wOC != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wOC);
      }
      paramInt = i;
      if (this.wOD != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wOD);
      }
      i = paramInt;
      if (this.wOE != null) {
        i = paramInt + e.a.a.a.iP(5, this.wOE.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(6, this.jJu) + e.a.a.a.c(7, 8, this.wOF);
      paramInt = i;
      if (this.wOG != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wOG);
      }
      i = paramInt;
      if (this.wOH != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wOH);
      }
      AppMethodBeat.o(28378);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wOF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Loc");
          AppMethodBeat.o(28378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vz localvz = (vz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28378);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvz.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28378);
          return 0;
        case 2: 
          localvz.Name = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28378);
          return 0;
        case 3: 
          localvz.wOC = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28378);
          return 0;
        case 4: 
          localvz.wOD = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28378);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvz.wOE = ((azt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28378);
          return 0;
        case 6: 
          localvz.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28378);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvz.wOF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28378);
          return 0;
        case 8: 
          localvz.wOG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28378);
          return 0;
        }
        localvz.wOH = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28378);
        return 0;
      }
      AppMethodBeat.o(28378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vz
 * JD-Core Version:    0.7.0.1
 */
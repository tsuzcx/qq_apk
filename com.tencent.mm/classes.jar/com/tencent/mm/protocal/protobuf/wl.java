package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class wl
  extends ckq
{
  public int CGZ;
  public String CIt;
  public String CYA;
  public LinkedList<wk> CYB;
  public cqu CYC;
  public cry CYD;
  public int CYz;
  public String CxC;
  public int scene;
  
  public wl()
  {
    AppMethodBeat.i(124474);
    this.CYB = new LinkedList();
    AppMethodBeat.o(124474);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124475);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.CYz);
      if (this.CYA != null) {
        paramVarArgs.d(3, this.CYA);
      }
      if (this.CIt != null) {
        paramVarArgs.d(4, this.CIt);
      }
      if (this.CxC != null) {
        paramVarArgs.d(5, this.CxC);
      }
      paramVarArgs.e(6, 8, this.CYB);
      paramVarArgs.aR(7, this.scene);
      paramVarArgs.aR(8, this.CGZ);
      if (this.CYC != null)
      {
        paramVarArgs.kX(9, this.CYC.computeSize());
        this.CYC.writeFields(paramVarArgs);
      }
      if (this.CYD != null)
      {
        paramVarArgs.kX(10, this.CYD.computeSize());
        this.CYD.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124475);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CYz);
      paramInt = i;
      if (this.CYA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CYA);
      }
      i = paramInt;
      if (this.CIt != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CIt);
      }
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CxC);
      }
      i = paramInt + f.a.a.a.c(6, 8, this.CYB) + f.a.a.b.b.a.bA(7, this.scene) + f.a.a.b.b.a.bA(8, this.CGZ);
      paramInt = i;
      if (this.CYC != null) {
        paramInt = i + f.a.a.a.kW(9, this.CYC.computeSize());
      }
      i = paramInt;
      if (this.CYD != null) {
        i = paramInt + f.a.a.a.kW(10, this.CYD.computeSize());
      }
      AppMethodBeat.o(124475);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CYB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        wl localwl = (wl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124475);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwl.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 2: 
          localwl.CYz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124475);
          return 0;
        case 3: 
          localwl.CYA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 4: 
          localwl.CIt = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 5: 
          localwl.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(124475);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwl.CYB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        case 7: 
          localwl.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124475);
          return 0;
        case 8: 
          localwl.CGZ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(124475);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localwl.CYC = ((cqu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124475);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cry();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cry)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localwl.CYD = ((cry)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124475);
        return 0;
      }
      AppMethodBeat.o(124475);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.wl
 * JD-Core Version:    0.7.0.1
 */
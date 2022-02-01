package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zj
  extends dop
{
  public String LkD;
  public LinkedList<dxm> LkE;
  public LinkedList<dxo> LkF;
  public LinkedList<dxl> LkG;
  public LinkedList<dxk> LkH;
  public LinkedList<dxn> LkI;
  public int oUv;
  
  public zj()
  {
    AppMethodBeat.i(32163);
    this.LkE = new LinkedList();
    this.LkF = new LinkedList();
    this.LkG = new LinkedList();
    this.LkH = new LinkedList();
    this.LkI = new LinkedList();
    AppMethodBeat.o(32163);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32164);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.oUv);
      if (this.LkD != null) {
        paramVarArgs.e(3, this.LkD);
      }
      paramVarArgs.e(4, 8, this.LkE);
      paramVarArgs.e(5, 8, this.LkF);
      paramVarArgs.e(6, 8, this.LkG);
      paramVarArgs.e(7, 8, this.LkH);
      paramVarArgs.e(8, 8, this.LkI);
      AppMethodBeat.o(32164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1140;
      }
    }
    label1140:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.oUv);
      paramInt = i;
      if (this.LkD != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.LkD);
      }
      i = g.a.a.a.c(4, 8, this.LkE);
      int j = g.a.a.a.c(5, 8, this.LkF);
      int k = g.a.a.a.c(6, 8, this.LkG);
      int m = g.a.a.a.c(7, 8, this.LkH);
      int n = g.a.a.a.c(8, 8, this.LkI);
      AppMethodBeat.o(32164);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LkE.clear();
        this.LkF.clear();
        this.LkG.clear();
        this.LkH.clear();
        this.LkI.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zj localzj = (zj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32164);
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
            localzj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 2: 
          localzj.oUv = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32164);
          return 0;
        case 3: 
          localzj.LkD = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32164);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxm();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzj.LkE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxo();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxo)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzj.LkF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzj.LkG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzj.LkH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxn();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dxn)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localzj.LkI.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      AppMethodBeat.o(32164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zj
 * JD-Core Version:    0.7.0.1
 */
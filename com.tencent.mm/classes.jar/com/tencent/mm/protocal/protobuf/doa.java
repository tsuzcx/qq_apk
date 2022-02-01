package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doa
  extends dop
{
  public LinkedList<akf> MQT;
  public int MQU;
  public int MQV;
  public LinkedList<aap> MQW;
  public int MQX;
  public aat MaO;
  public long clK;
  
  public doa()
  {
    AppMethodBeat.i(50105);
    this.MQT = new LinkedList();
    this.MQW = new LinkedList();
    AppMethodBeat.o(50105);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(50106);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.clK);
      paramVarArgs.e(3, 8, this.MQT);
      paramVarArgs.aM(5, this.MQU);
      paramVarArgs.aM(6, this.MQV);
      if (this.MaO != null)
      {
        paramVarArgs.ni(7, this.MaO.computeSize());
        this.MaO.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.MQW);
      paramVarArgs.aM(9, this.MQX);
      AppMethodBeat.o(50106);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.clK) + g.a.a.a.c(3, 8, this.MQT) + g.a.a.b.b.a.bu(5, this.MQU) + g.a.a.b.b.a.bu(6, this.MQV);
      paramInt = i;
      if (this.MaO != null) {
        paramInt = i + g.a.a.a.nh(7, this.MaO.computeSize());
      }
      i = g.a.a.a.c(8, 8, this.MQW);
      int j = g.a.a.b.b.a.bu(9, this.MQX);
      AppMethodBeat.o(50106);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MQT.clear();
        this.MQW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(50106);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        doa localdoa = (doa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(50106);
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
            localdoa.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 2: 
          localdoa.clK = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(50106);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new akf();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((akf)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdoa.MQT.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 5: 
          localdoa.MQU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(50106);
          return 0;
        case 6: 
          localdoa.MQV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(50106);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aat();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aat)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdoa.MaO = ((aat)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aap();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aap)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdoa.MQW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(50106);
          return 0;
        }
        localdoa.MQX = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(50106);
        return 0;
      }
      AppMethodBeat.o(50106);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doa
 * JD-Core Version:    0.7.0.1
 */
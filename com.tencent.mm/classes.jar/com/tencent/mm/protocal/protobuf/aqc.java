package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aqc
  extends dop
{
  public aov LAI;
  public String LBY;
  public b LBZ;
  public LinkedList<bdu> LCa;
  public axk LCb;
  public int LCc;
  public LinkedList<String> LCd;
  public int businessType;
  public String clientId;
  public String finderUsername;
  public FinderObjectDesc objectDesc;
  public int scene;
  
  public aqc()
  {
    AppMethodBeat.i(209369);
    this.LCa = new LinkedList();
    this.LCd = new LinkedList();
    AppMethodBeat.o(209369);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209370);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.LAI != null)
      {
        paramVarArgs.ni(2, this.LAI.computeSize());
        this.LAI.writeFields(paramVarArgs);
      }
      if (this.finderUsername != null) {
        paramVarArgs.e(3, this.finderUsername);
      }
      if (this.objectDesc != null)
      {
        paramVarArgs.ni(4, this.objectDesc.computeSize());
        this.objectDesc.writeFields(paramVarArgs);
      }
      if (this.clientId != null) {
        paramVarArgs.e(5, this.clientId);
      }
      if (this.LBY != null) {
        paramVarArgs.e(6, this.LBY);
      }
      paramVarArgs.aM(7, this.businessType);
      paramVarArgs.aM(8, this.scene);
      if (this.LBZ != null) {
        paramVarArgs.c(9, this.LBZ);
      }
      paramVarArgs.e(10, 8, this.LCa);
      if (this.LCb != null)
      {
        paramVarArgs.ni(11, this.LCb.computeSize());
        this.LCb.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(12, this.LCc);
      paramVarArgs.e(13, 1, this.LCd);
      AppMethodBeat.o(209370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1358;
      }
    }
    label1358:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LAI != null) {
        paramInt = i + g.a.a.a.nh(2, this.LAI.computeSize());
      }
      i = paramInt;
      if (this.finderUsername != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.finderUsername);
      }
      paramInt = i;
      if (this.objectDesc != null) {
        paramInt = i + g.a.a.a.nh(4, this.objectDesc.computeSize());
      }
      i = paramInt;
      if (this.clientId != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.clientId);
      }
      paramInt = i;
      if (this.LBY != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.LBY);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.businessType) + g.a.a.b.b.a.bu(8, this.scene);
      paramInt = i;
      if (this.LBZ != null) {
        paramInt = i + g.a.a.b.b.a.b(9, this.LBZ);
      }
      i = paramInt + g.a.a.a.c(10, 8, this.LCa);
      paramInt = i;
      if (this.LCb != null) {
        paramInt = i + g.a.a.a.nh(11, this.LCb.computeSize());
      }
      i = g.a.a.b.b.a.bu(12, this.LCc);
      int j = g.a.a.a.c(13, 1, this.LCd);
      AppMethodBeat.o(209370);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LCa.clear();
        this.LCd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aqc localaqc = (aqc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209370);
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
            localaqc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209370);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqc.LAI = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209370);
          return 0;
        case 3: 
          localaqc.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209370);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObjectDesc();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObjectDesc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqc.objectDesc = ((FinderObjectDesc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209370);
          return 0;
        case 5: 
          localaqc.clientId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209370);
          return 0;
        case 6: 
          localaqc.LBY = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209370);
          return 0;
        case 7: 
          localaqc.businessType = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209370);
          return 0;
        case 8: 
          localaqc.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209370);
          return 0;
        case 9: 
          localaqc.LBZ = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(209370);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bdu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bdu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqc.LCa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209370);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new axk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((axk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaqc.LCb = ((axk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209370);
          return 0;
        case 12: 
          localaqc.LCc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209370);
          return 0;
        }
        localaqc.LCd.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(209370);
        return 0;
      }
      AppMethodBeat.o(209370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqc
 * JD-Core Version:    0.7.0.1
 */
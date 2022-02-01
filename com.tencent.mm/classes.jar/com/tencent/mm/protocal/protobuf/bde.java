package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bde
  extends dop
{
  public LinkedList<FinderContact> LDz;
  public LinkedList<FinderContact> LKE;
  public SKBuiltinBuffer_t LMX;
  public LinkedList<bbi> LMY;
  public String LMZ;
  public LinkedList<bbi> LNa;
  public String LNb;
  public int dML;
  public String finderUsername;
  public int scene;
  public aov uli;
  
  public bde()
  {
    AppMethodBeat.i(169060);
    this.LDz = new LinkedList();
    this.LKE = new LinkedList();
    this.LMY = new LinkedList();
    this.LNa = new LinkedList();
    AppMethodBeat.o(169060);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169061);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.dML);
      if (this.LMX != null)
      {
        paramVarArgs.ni(3, this.LMX.computeSize());
        this.LMX.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.LDz);
      paramVarArgs.e(5, 8, this.LKE);
      if (this.finderUsername != null) {
        paramVarArgs.e(6, this.finderUsername);
      }
      if (this.uli != null)
      {
        paramVarArgs.ni(7, this.uli.computeSize());
        this.uli.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(8, this.scene);
      paramVarArgs.e(9, 8, this.LMY);
      if (this.LMZ != null) {
        paramVarArgs.e(10, this.LMZ);
      }
      paramVarArgs.e(11, 8, this.LNa);
      if (this.LNb != null) {
        paramVarArgs.e(12, this.LNb);
      }
      AppMethodBeat.o(169061);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1454;
      }
    }
    label1454:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.dML);
      paramInt = i;
      if (this.LMX != null) {
        paramInt = i + g.a.a.a.nh(3, this.LMX.computeSize());
      }
      i = paramInt + g.a.a.a.c(4, 8, this.LDz) + g.a.a.a.c(5, 8, this.LKE);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.finderUsername);
      }
      i = paramInt;
      if (this.uli != null) {
        i = paramInt + g.a.a.a.nh(7, this.uli.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(8, this.scene) + g.a.a.a.c(9, 8, this.LMY);
      paramInt = i;
      if (this.LMZ != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.LMZ);
      }
      i = paramInt + g.a.a.a.c(11, 8, this.LNa);
      paramInt = i;
      if (this.LNb != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.LNb);
      }
      AppMethodBeat.o(169061);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LDz.clear();
        this.LKE.clear();
        this.LMY.clear();
        this.LNa.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(169061);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bde localbde = (bde)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169061);
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
            localbde.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 2: 
          localbde.dML = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169061);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbde.LMX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbde.LDz.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbde.LKE.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 6: 
          localbde.finderUsername = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aov();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aov)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbde.uli = ((aov)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 8: 
          localbde.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(169061);
          return 0;
        case 9: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbde.LMY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        case 10: 
          localbde.LMZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(169061);
          return 0;
        case 11: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bbi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bbi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbde.LNa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169061);
          return 0;
        }
        localbde.LNb = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(169061);
        return 0;
      }
      AppMethodBeat.o(169061);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bde
 * JD-Core Version:    0.7.0.1
 */
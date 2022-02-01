package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class enc
  extends dop
{
  public String MTQ;
  public int NkT;
  public int NkU;
  public String NkV;
  public int NkW;
  public String NkX;
  public LinkedList<ece> NkY;
  public int NkZ;
  public int Nla;
  public int cmD;
  public String dGL;
  public String dGP;
  public String ixZ;
  
  public enc()
  {
    AppMethodBeat.i(116818);
    this.NkY = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dGL != null) {
        paramVarArgs.e(2, this.dGL);
      }
      if (this.dGP != null) {
        paramVarArgs.e(3, this.dGP);
      }
      paramVarArgs.aM(4, this.NkT);
      paramVarArgs.aM(5, this.NkU);
      paramVarArgs.aM(6, this.cmD);
      if (this.NkV != null) {
        paramVarArgs.e(7, this.NkV);
      }
      if (this.MTQ != null) {
        paramVarArgs.e(8, this.MTQ);
      }
      if (this.ixZ != null) {
        paramVarArgs.e(9, this.ixZ);
      }
      paramVarArgs.aM(10, this.NkW);
      if (this.NkX != null) {
        paramVarArgs.e(11, this.NkX);
      }
      paramVarArgs.e(12, 8, this.NkY);
      paramVarArgs.aM(13, this.NkZ);
      paramVarArgs.aM(14, this.Nla);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dGL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dGL);
      }
      i = paramInt;
      if (this.dGP != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dGP);
      }
      i = i + g.a.a.b.b.a.bu(4, this.NkT) + g.a.a.b.b.a.bu(5, this.NkU) + g.a.a.b.b.a.bu(6, this.cmD);
      paramInt = i;
      if (this.NkV != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.NkV);
      }
      i = paramInt;
      if (this.MTQ != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.MTQ);
      }
      paramInt = i;
      if (this.ixZ != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.ixZ);
      }
      i = paramInt + g.a.a.b.b.a.bu(10, this.NkW);
      paramInt = i;
      if (this.NkX != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.NkX);
      }
      i = g.a.a.a.c(12, 8, this.NkY);
      int j = g.a.a.b.b.a.bu(13, this.NkZ);
      int k = g.a.a.b.b.a.bu(14, this.Nla);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NkY.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        enc localenc = (enc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
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
            localenc.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localenc.dGL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localenc.dGP = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localenc.NkT = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localenc.NkU = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localenc.cmD = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localenc.NkV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localenc.MTQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localenc.ixZ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localenc.NkW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localenc.NkX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ece();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ece)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localenc.NkY.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localenc.NkZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(116819);
          return 0;
        }
        localenc.Nla = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.enc
 * JD-Core Version:    0.7.0.1
 */
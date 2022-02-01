package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxe
  extends dop
{
  public eck KDj;
  public String LTz;
  public int MXj;
  public dxy MXk;
  public int eaQ;
  public String gTT;
  public LinkedList<dxg> iAd;
  
  public dxe()
  {
    AppMethodBeat.i(114070);
    this.iAd = new LinkedList();
    AppMethodBeat.o(114070);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114071);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.MXj);
      paramVarArgs.e(3, 8, this.iAd);
      if (this.gTT != null) {
        paramVarArgs.e(4, this.gTT);
      }
      if (this.LTz != null) {
        paramVarArgs.e(5, this.LTz);
      }
      if (this.MXk != null)
      {
        paramVarArgs.ni(6, this.MXk.computeSize());
        this.MXk.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(7, this.eaQ);
      if (this.KDj != null)
      {
        paramVarArgs.ni(8, this.KDj.computeSize());
        this.KDj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114071);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.MXj) + g.a.a.a.c(3, 8, this.iAd);
      paramInt = i;
      if (this.gTT != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.gTT);
      }
      i = paramInt;
      if (this.LTz != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.LTz);
      }
      paramInt = i;
      if (this.MXk != null) {
        paramInt = i + g.a.a.a.nh(6, this.MXk.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.eaQ);
      paramInt = i;
      if (this.KDj != null) {
        paramInt = i + g.a.a.a.nh(8, this.KDj.computeSize());
      }
      AppMethodBeat.o(114071);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.iAd.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dxe localdxe = (dxe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114071);
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
            localdxe.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 2: 
          localdxe.MXj = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114071);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxg();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxg)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdxe.iAd.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 4: 
          localdxe.gTT = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 5: 
          localdxe.LTz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114071);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxy();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdxe.MXk = ((dxy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114071);
          return 0;
        case 7: 
          localdxe.eaQ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114071);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eck();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((eck)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localdxe.KDj = ((eck)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114071);
        return 0;
      }
      AppMethodBeat.o(114071);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxe
 * JD-Core Version:    0.7.0.1
 */
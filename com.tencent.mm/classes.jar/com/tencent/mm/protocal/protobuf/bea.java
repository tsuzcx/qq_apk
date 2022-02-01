package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bea
  extends dpc
{
  public LinkedList<FinderObject> LCW;
  public int LNG;
  public int LNH;
  public int LNI;
  public aso LNJ;
  public FinderContact contact;
  
  public bea()
  {
    AppMethodBeat.i(209711);
    this.LCW = new LinkedList();
    AppMethodBeat.o(209711);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209712);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.ni(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.contact != null)
      {
        paramVarArgs.ni(2, this.contact.computeSize());
        this.contact.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.LNG);
      paramVarArgs.e(4, 8, this.LCW);
      paramVarArgs.aM(5, this.LNH);
      paramVarArgs.aM(6, this.LNI);
      if (this.LNJ != null)
      {
        paramVarArgs.ni(7, this.LNJ.computeSize());
        this.LNJ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(209712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = g.a.a.a.nh(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.contact != null) {
        i = paramInt + g.a.a.a.nh(2, this.contact.computeSize());
      }
      i = i + g.a.a.b.b.a.bu(3, this.LNG) + g.a.a.a.c(4, 8, this.LCW) + g.a.a.b.b.a.bu(5, this.LNH) + g.a.a.b.b.a.bu(6, this.LNI);
      paramInt = i;
      if (this.LNJ != null) {
        paramInt = i + g.a.a.a.nh(7, this.LNJ.computeSize());
      }
      AppMethodBeat.o(209712);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LCW.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dpc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dpc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bea localbea = (bea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209712);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbea.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209712);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderContact();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbea.contact = ((FinderContact)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209712);
          return 0;
        case 3: 
          localbea.LNG = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209712);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new FinderObject();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbea.LCW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209712);
          return 0;
        case 5: 
          localbea.LNH = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209712);
          return 0;
        case 6: 
          localbea.LNI = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(209712);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aso();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aso)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dpc.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localbea.LNJ = ((aso)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(209712);
        return 0;
      }
      AppMethodBeat.o(209712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bea
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ae
  extends dop
{
  public String KCA;
  public String KCt;
  public String KCu;
  public String KCv;
  public LinkedList<ei> KCw;
  public int KCx;
  public String KCy;
  public int KCz;
  public int OpCode;
  public String SSID;
  public String URL;
  
  public ae()
  {
    AppMethodBeat.i(32095);
    this.KCw = new LinkedList();
    AppMethodBeat.o(32095);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32096);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.e(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.e(3, this.SSID);
      }
      if (this.KCt != null) {
        paramVarArgs.e(4, this.KCt);
      }
      if (this.KCu != null) {
        paramVarArgs.e(5, this.KCu);
      }
      if (this.KCv != null) {
        paramVarArgs.e(6, this.KCv);
      }
      paramVarArgs.aM(7, this.OpCode);
      paramVarArgs.e(8, 8, this.KCw);
      paramVarArgs.aM(9, this.KCx);
      if (this.KCy != null) {
        paramVarArgs.e(10, this.KCy);
      }
      paramVarArgs.aM(11, this.KCz);
      if (this.KCA != null) {
        paramVarArgs.e(12, this.KCA);
      }
      AppMethodBeat.o(32096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1032;
      }
    }
    label1032:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.URL);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.SSID);
      }
      paramInt = i;
      if (this.KCt != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KCt);
      }
      i = paramInt;
      if (this.KCu != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KCu);
      }
      paramInt = i;
      if (this.KCv != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KCv);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.OpCode) + g.a.a.a.c(8, 8, this.KCw) + g.a.a.b.b.a.bu(9, this.KCx);
      paramInt = i;
      if (this.KCy != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.KCy);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.KCz);
      paramInt = i;
      if (this.KCA != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.KCA);
      }
      AppMethodBeat.o(32096);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KCw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(32096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ae localae = (ae)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32096);
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
            localae.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 2: 
          localae.URL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 3: 
          localae.SSID = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 4: 
          localae.KCt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 5: 
          localae.KCu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 6: 
          localae.KCv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 7: 
          localae.OpCode = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32096);
          return 0;
        case 8: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ei();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ei)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localae.KCw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 9: 
          localae.KCx = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32096);
          return 0;
        case 10: 
          localae.KCy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 11: 
          localae.KCz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(32096);
          return 0;
        }
        localae.KCA = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32096);
        return 0;
      }
      AppMethodBeat.o(32096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ae
 * JD-Core Version:    0.7.0.1
 */
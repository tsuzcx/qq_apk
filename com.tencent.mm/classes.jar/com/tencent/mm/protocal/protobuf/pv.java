package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pv
  extends dop
{
  public int AKt;
  public String CEM;
  public String CEN;
  public int count;
  public String hid;
  public String hie;
  public String hif;
  public String hig;
  public String hih;
  public int hii;
  public String hij;
  public int type;
  public String value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124452);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hid != null) {
        paramVarArgs.e(2, this.hid);
      }
      if (this.hie != null) {
        paramVarArgs.e(3, this.hie);
      }
      if (this.hif != null) {
        paramVarArgs.e(4, this.hif);
      }
      if (this.hig != null) {
        paramVarArgs.e(5, this.hig);
      }
      if (this.hih != null) {
        paramVarArgs.e(6, this.hih);
      }
      paramVarArgs.aM(7, this.hii);
      if (this.hij != null) {
        paramVarArgs.e(8, this.hij);
      }
      if (this.CEN != null) {
        paramVarArgs.e(9, this.CEN);
      }
      if (this.CEM != null) {
        paramVarArgs.e(10, this.CEM);
      }
      paramVarArgs.aM(11, this.type);
      if (this.value != null) {
        paramVarArgs.e(12, this.value);
      }
      paramVarArgs.aM(13, this.count);
      paramVarArgs.aM(14, this.AKt);
      AppMethodBeat.o(124452);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1046;
      }
    }
    label1046:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hid != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.hid);
      }
      i = paramInt;
      if (this.hie != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.hie);
      }
      paramInt = i;
      if (this.hif != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.hif);
      }
      i = paramInt;
      if (this.hig != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.hig);
      }
      paramInt = i;
      if (this.hih != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.hih);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.hii);
      paramInt = i;
      if (this.hij != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.hij);
      }
      i = paramInt;
      if (this.CEN != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.CEN);
      }
      paramInt = i;
      if (this.CEM != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.CEM);
      }
      i = paramInt + g.a.a.b.b.a.bu(11, this.type);
      paramInt = i;
      if (this.value != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.value);
      }
      i = g.a.a.b.b.a.bu(13, this.count);
      int j = g.a.a.b.b.a.bu(14, this.AKt);
      AppMethodBeat.o(124452);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124452);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        pv localpv = (pv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124452);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localpv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124452);
          return 0;
        case 2: 
          localpv.hid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 3: 
          localpv.hie = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 4: 
          localpv.hif = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 5: 
          localpv.hig = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 6: 
          localpv.hih = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 7: 
          localpv.hii = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124452);
          return 0;
        case 8: 
          localpv.hij = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 9: 
          localpv.CEN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 10: 
          localpv.CEM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 11: 
          localpv.type = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124452);
          return 0;
        case 12: 
          localpv.value = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124452);
          return 0;
        case 13: 
          localpv.count = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124452);
          return 0;
        }
        localpv.AKt = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(124452);
        return 0;
      }
      AppMethodBeat.o(124452);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pv
 * JD-Core Version:    0.7.0.1
 */
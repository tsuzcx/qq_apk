package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bng
  extends dop
{
  public String KRe;
  public czu LUV;
  public int LVP;
  public String LVQ;
  public b LVR;
  public boolean LVS;
  public String LjH;
  public String action_data;
  public String person_id;
  public String qGp;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104371);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.person_id != null) {
        paramVarArgs.e(2, this.person_id);
      }
      if (this.action_data != null) {
        paramVarArgs.e(3, this.action_data);
      }
      paramVarArgs.aM(4, this.LVP);
      if (this.LVQ != null) {
        paramVarArgs.e(5, this.LVQ);
      }
      if (this.KRe != null) {
        paramVarArgs.e(6, this.KRe);
      }
      paramVarArgs.aM(7, this.scene);
      if (this.LjH != null) {
        paramVarArgs.e(8, this.LjH);
      }
      if (this.qGp != null) {
        paramVarArgs.e(9, this.qGp);
      }
      if (this.LUV != null)
      {
        paramVarArgs.ni(10, this.LUV.computeSize());
        this.LUV.writeFields(paramVarArgs);
      }
      if (this.LVR != null) {
        paramVarArgs.c(11, this.LVR);
      }
      paramVarArgs.cc(12, this.LVS);
      AppMethodBeat.o(104371);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1030;
      }
    }
    label1030:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.person_id != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.person_id);
      }
      i = paramInt;
      if (this.action_data != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.action_data);
      }
      i += g.a.a.b.b.a.bu(4, this.LVP);
      paramInt = i;
      if (this.LVQ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.LVQ);
      }
      i = paramInt;
      if (this.KRe != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KRe);
      }
      i += g.a.a.b.b.a.bu(7, this.scene);
      paramInt = i;
      if (this.LjH != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.LjH);
      }
      i = paramInt;
      if (this.qGp != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.qGp);
      }
      paramInt = i;
      if (this.LUV != null) {
        paramInt = i + g.a.a.a.nh(10, this.LUV.computeSize());
      }
      i = paramInt;
      if (this.LVR != null) {
        i = paramInt + g.a.a.b.b.a.b(11, this.LVR);
      }
      paramInt = g.a.a.b.b.a.fS(12);
      AppMethodBeat.o(104371);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(104371);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bng localbng = (bng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104371);
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
            localbng.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 2: 
          localbng.person_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 3: 
          localbng.action_data = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 4: 
          localbng.LVP = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104371);
          return 0;
        case 5: 
          localbng.LVQ = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 6: 
          localbng.KRe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 7: 
          localbng.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(104371);
          return 0;
        case 8: 
          localbng.LjH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 9: 
          localbng.qGp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(104371);
          return 0;
        case 10: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czu();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localbng.LUV = ((czu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104371);
          return 0;
        case 11: 
          localbng.LVR = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(104371);
          return 0;
        }
        localbng.LVS = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(104371);
        return 0;
      }
      AppMethodBeat.o(104371);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bng
 * JD-Core Version:    0.7.0.1
 */
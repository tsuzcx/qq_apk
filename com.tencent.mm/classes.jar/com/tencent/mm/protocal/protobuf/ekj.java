package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ekj
  extends dop
{
  public String KBM;
  public String KHN;
  public String NjB;
  public String Njb;
  public String Njc;
  public String Njt;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72609);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KBM != null) {
        paramVarArgs.e(2, this.KBM);
      }
      if (this.KHN != null) {
        paramVarArgs.e(3, this.KHN);
      }
      if (this.Njb != null) {
        paramVarArgs.e(4, this.Njb);
      }
      if (this.Njc != null) {
        paramVarArgs.e(5, this.Njc);
      }
      paramVarArgs.aM(6, this.yRL);
      if (this.Njt != null) {
        paramVarArgs.e(7, this.Njt);
      }
      if (this.NjB != null) {
        paramVarArgs.e(8, this.NjB);
      }
      AppMethodBeat.o(72609);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label722;
      }
    }
    label722:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KBM != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.KBM);
      }
      i = paramInt;
      if (this.KHN != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KHN);
      }
      paramInt = i;
      if (this.Njb != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Njb);
      }
      i = paramInt;
      if (this.Njc != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Njc);
      }
      i += g.a.a.b.b.a.bu(6, this.yRL);
      paramInt = i;
      if (this.Njt != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.Njt);
      }
      i = paramInt;
      if (this.NjB != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.NjB);
      }
      AppMethodBeat.o(72609);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72609);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ekj localekj = (ekj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72609);
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
            localekj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72609);
          return 0;
        case 2: 
          localekj.KBM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 3: 
          localekj.KHN = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 4: 
          localekj.Njb = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 5: 
          localekj.Njc = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72609);
          return 0;
        case 6: 
          localekj.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(72609);
          return 0;
        case 7: 
          localekj.Njt = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72609);
          return 0;
        }
        localekj.NjB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(72609);
        return 0;
      }
      AppMethodBeat.o(72609);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ekj
 * JD-Core Version:    0.7.0.1
 */
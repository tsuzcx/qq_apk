package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epy
  extends dop
{
  public String IaW;
  public String KLH;
  public LinkedList<Integer> MNJ;
  public String MVO;
  public String MVP;
  public String MVR;
  public String dDj;
  public String dHx;
  public String dNI;
  
  public epy()
  {
    AppMethodBeat.i(123675);
    this.MNJ = new LinkedList();
    AppMethodBeat.o(123675);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123676);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      paramVarArgs.e(3, 2, this.MNJ);
      if (this.MVO != null) {
        paramVarArgs.e(4, this.MVO);
      }
      if (this.KLH != null) {
        paramVarArgs.e(5, this.KLH);
      }
      if (this.dHx != null) {
        paramVarArgs.e(6, this.dHx);
      }
      if (this.IaW != null) {
        paramVarArgs.e(7, this.IaW);
      }
      if (this.MVR != null) {
        paramVarArgs.e(8, this.MVR);
      }
      if (this.dDj != null) {
        paramVarArgs.e(9, this.dDj);
      }
      if (this.MVP != null) {
        paramVarArgs.e(10, this.MVP);
      }
      AppMethodBeat.o(123676);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label861;
      }
    }
    label861:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.dNI);
      }
      i += g.a.a.a.c(3, 2, this.MNJ);
      paramInt = i;
      if (this.MVO != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MVO);
      }
      i = paramInt;
      if (this.KLH != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KLH);
      }
      paramInt = i;
      if (this.dHx != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dHx);
      }
      i = paramInt;
      if (this.IaW != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.IaW);
      }
      paramInt = i;
      if (this.MVR != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MVR);
      }
      i = paramInt;
      if (this.dDj != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.dDj);
      }
      paramInt = i;
      if (this.MVP != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MVP);
      }
      AppMethodBeat.o(123676);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.MNJ.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123676);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        epy localepy = (epy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123676);
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
            localepy.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123676);
          return 0;
        case 2: 
          localepy.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 3: 
          localepy.MNJ.add(Integer.valueOf(((g.a.a.a.a)localObject1).UbS.zi()));
          AppMethodBeat.o(123676);
          return 0;
        case 4: 
          localepy.MVO = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 5: 
          localepy.KLH = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 6: 
          localepy.dHx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 7: 
          localepy.IaW = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 8: 
          localepy.MVR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        case 9: 
          localepy.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123676);
          return 0;
        }
        localepy.MVP = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(123676);
        return 0;
      }
      AppMethodBeat.o(123676);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epy
 * JD-Core Version:    0.7.0.1
 */
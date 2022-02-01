package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ke
  extends dop
{
  public LinkedList<String> KOv;
  public LinkedList<don> KOw;
  public long KOx;
  public int KOy;
  public int KOz;
  public String pLm;
  
  public ke()
  {
    AppMethodBeat.i(6394);
    this.KOv = new LinkedList();
    this.KOw = new LinkedList();
    AppMethodBeat.o(6394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6395);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 1, this.KOv);
      paramVarArgs.e(3, 8, this.KOw);
      if (this.pLm != null) {
        paramVarArgs.e(4, this.pLm);
      }
      paramVarArgs.bb(5, this.KOx);
      paramVarArgs.aM(6, this.KOy);
      paramVarArgs.aM(7, this.KOz);
      AppMethodBeat.o(6395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label719;
      }
    }
    label719:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 1, this.KOv) + g.a.a.a.c(3, 8, this.KOw);
      paramInt = i;
      if (this.pLm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.pLm);
      }
      i = g.a.a.b.b.a.r(5, this.KOx);
      int j = g.a.a.b.b.a.bu(6, this.KOy);
      int k = g.a.a.b.b.a.bu(7, this.KOz);
      AppMethodBeat.o(6395);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KOv.clear();
        this.KOw.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(6395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ke localke = (ke)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6395);
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
            localke.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 2: 
          localke.KOv.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(6395);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new don();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((don)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localke.KOw.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6395);
          return 0;
        case 4: 
          localke.pLm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(6395);
          return 0;
        case 5: 
          localke.KOx = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(6395);
          return 0;
        case 6: 
          localke.KOy = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(6395);
          return 0;
        }
        localke.KOz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(6395);
        return 0;
      }
      AppMethodBeat.o(6395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ke
 * JD-Core Version:    0.7.0.1
 */
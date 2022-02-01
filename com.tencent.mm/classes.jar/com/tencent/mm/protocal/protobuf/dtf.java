package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtf
  extends dop
{
  public int KXD;
  public String KZR;
  public String Lmp;
  public String MVs;
  public String dNI;
  public int scene;
  public int source;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91683);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Lmp != null) {
        paramVarArgs.e(2, this.Lmp);
      }
      if (this.dNI != null) {
        paramVarArgs.e(3, this.dNI);
      }
      if (this.url != null) {
        paramVarArgs.e(4, this.url);
      }
      if (this.MVs != null) {
        paramVarArgs.e(5, this.MVs);
      }
      paramVarArgs.aM(6, this.scene);
      paramVarArgs.aM(7, this.source);
      if (this.KZR != null) {
        paramVarArgs.e(8, this.KZR);
      }
      paramVarArgs.aM(9, this.KXD);
      AppMethodBeat.o(91683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Lmp != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Lmp);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.dNI);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.url);
      }
      i = paramInt;
      if (this.MVs != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MVs);
      }
      i = i + g.a.a.b.b.a.bu(6, this.scene) + g.a.a.b.b.a.bu(7, this.source);
      paramInt = i;
      if (this.KZR != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KZR);
      }
      i = g.a.a.b.b.a.bu(9, this.KXD);
      AppMethodBeat.o(91683);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        dtf localdtf = (dtf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91683);
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
            localdtf.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91683);
          return 0;
        case 2: 
          localdtf.Lmp = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 3: 
          localdtf.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 4: 
          localdtf.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 5: 
          localdtf.MVs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 6: 
          localdtf.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91683);
          return 0;
        case 7: 
          localdtf.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91683);
          return 0;
        case 8: 
          localdtf.KZR = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91683);
          return 0;
        }
        localdtf.KXD = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91683);
        return 0;
      }
      AppMethodBeat.o(91683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtf
 * JD-Core Version:    0.7.0.1
 */
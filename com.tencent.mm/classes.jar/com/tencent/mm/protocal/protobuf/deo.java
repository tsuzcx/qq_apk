package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class deo
  extends dop
{
  public String LoB;
  public String MJG;
  public int Meb;
  public String request_id;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(214320);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.request_id != null) {
        paramVarArgs.e(2, this.request_id);
      }
      if (this.MJG != null) {
        paramVarArgs.e(3, this.MJG);
      }
      paramVarArgs.aM(4, this.Meb);
      paramVarArgs.aM(100, this.scene);
      if (this.LoB != null) {
        paramVarArgs.e(101, this.LoB);
      }
      AppMethodBeat.o(214320);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label602;
      }
    }
    label602:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.request_id != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.request_id);
      }
      i = paramInt;
      if (this.MJG != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MJG);
      }
      i = i + g.a.a.b.b.a.bu(4, this.Meb) + g.a.a.b.b.a.bu(100, this.scene);
      paramInt = i;
      if (this.LoB != null) {
        paramInt = i + g.a.a.b.b.a.f(101, this.LoB);
      }
      AppMethodBeat.o(214320);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(214320);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        deo localdeo = (deo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(214320);
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
            localdeo.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(214320);
          return 0;
        case 2: 
          localdeo.request_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214320);
          return 0;
        case 3: 
          localdeo.MJG = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(214320);
          return 0;
        case 4: 
          localdeo.Meb = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214320);
          return 0;
        case 100: 
          localdeo.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(214320);
          return 0;
        }
        localdeo.LoB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(214320);
        return 0;
      }
      AppMethodBeat.o(214320);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.deo
 * JD-Core Version:    0.7.0.1
 */
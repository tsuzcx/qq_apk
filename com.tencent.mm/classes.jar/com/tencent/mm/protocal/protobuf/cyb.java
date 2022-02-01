package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyb
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KIA;
  public SKBuiltinBuffer_t MDa;
  public String Md5;
  public String Name;
  public String PackName;
  public int Version;
  public int oUq;
  public int xNF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152659);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.xNF);
      paramVarArgs.aM(2, this.Version);
      if (this.Name != null) {
        paramVarArgs.e(3, this.Name);
      }
      paramVarArgs.aM(4, this.oUq);
      if (this.KIA != null)
      {
        paramVarArgs.ni(5, this.KIA.computeSize());
        this.KIA.writeFields(paramVarArgs);
      }
      if (this.PackName != null) {
        paramVarArgs.e(6, this.PackName);
      }
      if (this.MDa != null)
      {
        paramVarArgs.ni(7, this.MDa.computeSize());
        this.MDa.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.xNF) + 0 + g.a.a.b.b.a.bu(2, this.Version);
      paramInt = i;
      if (this.Name != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Name);
      }
      i = paramInt + g.a.a.b.b.a.bu(4, this.oUq);
      paramInt = i;
      if (this.KIA != null) {
        paramInt = i + g.a.a.a.nh(5, this.KIA.computeSize());
      }
      i = paramInt;
      if (this.PackName != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.PackName);
      }
      paramInt = i;
      if (this.MDa != null) {
        paramInt = i + g.a.a.a.nh(7, this.MDa.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.Md5);
      }
      AppMethodBeat.o(152659);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(152659);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      cyb localcyb = (cyb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152659);
        return -1;
      case 1: 
        localcyb.xNF = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152659);
        return 0;
      case 2: 
        localcyb.Version = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152659);
        return 0;
      case 3: 
        localcyb.Name = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 4: 
        localcyb.oUq = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152659);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcyb.KIA = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      case 6: 
        localcyb.PackName = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152659);
        return 0;
      case 7: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcyb.MDa = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152659);
        return 0;
      }
      localcyb.Md5 = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(152659);
      return 0;
    }
    AppMethodBeat.o(152659);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyb
 * JD-Core Version:    0.7.0.1
 */
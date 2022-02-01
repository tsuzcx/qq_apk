package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class zg
  extends com.tencent.mm.bw.a
{
  public cfl IoL;
  public cfl IoM;
  public String KYs;
  public int LkA;
  public String Lkz;
  public String dQx;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177332);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      if (this.IoL != null)
      {
        paramVarArgs.ni(3, this.IoL.computeSize());
        this.IoL.writeFields(paramVarArgs);
      }
      if (this.IoM != null)
      {
        paramVarArgs.ni(4, this.IoM.computeSize());
        this.IoM.writeFields(paramVarArgs);
      }
      if (this.Lkz != null) {
        paramVarArgs.e(5, this.Lkz);
      }
      if (this.KYs != null) {
        paramVarArgs.e(6, this.KYs);
      }
      paramVarArgs.aM(7, this.LkA);
      AppMethodBeat.o(177332);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label754;
      }
    }
    label754:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt;
      if (this.IoL != null) {
        i = paramInt + g.a.a.a.nh(3, this.IoL.computeSize());
      }
      paramInt = i;
      if (this.IoM != null) {
        paramInt = i + g.a.a.a.nh(4, this.IoM.computeSize());
      }
      i = paramInt;
      if (this.Lkz != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Lkz);
      }
      paramInt = i;
      if (this.KYs != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KYs);
      }
      i = g.a.a.b.b.a.bu(7, this.LkA);
      AppMethodBeat.o(177332);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(177332);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        zg localzg = (zg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(177332);
          return -1;
        case 1: 
          localzg.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 2: 
          localzg.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzg.IoL = ((cfl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localzg.IoM = ((cfl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177332);
          return 0;
        case 5: 
          localzg.Lkz = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(177332);
          return 0;
        case 6: 
          localzg.KYs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(177332);
          return 0;
        }
        localzg.LkA = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(177332);
        return 0;
      }
      AppMethodBeat.o(177332);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zg
 * JD-Core Version:    0.7.0.1
 */
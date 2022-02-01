package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dzc
  extends com.tencent.mm.bw.a
{
  public String Gdr;
  public int Gfl;
  public int Gfm;
  public String Gfr;
  public dyu Gfs;
  public dzb Gft;
  public String Md5;
  public String sVp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110863);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gfr == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.Gdr == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(110863);
        throw paramVarArgs;
      }
      if (this.Gfr != null) {
        paramVarArgs.d(4, this.Gfr);
      }
      if (this.Gdr != null) {
        paramVarArgs.d(12, this.Gdr);
      }
      if (this.Gfs != null)
      {
        paramVarArgs.ln(9, this.Gfs.computeSize());
        this.Gfs.writeFields(paramVarArgs);
      }
      if (this.Gft != null)
      {
        paramVarArgs.ln(10, this.Gft.computeSize());
        this.Gft.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.d(5, this.Md5);
      }
      if (this.sVp != null) {
        paramVarArgs.d(6, this.sVp);
      }
      paramVarArgs.aR(7, this.Gfl);
      paramVarArgs.aR(8, this.Gfm);
      AppMethodBeat.o(110863);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gfr == null) {
        break label906;
      }
    }
    label906:
    for (int i = f.a.a.b.b.a.e(4, this.Gfr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Gdr != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Gdr);
      }
      i = paramInt;
      if (this.Gfs != null) {
        i = paramInt + f.a.a.a.lm(9, this.Gfs.computeSize());
      }
      paramInt = i;
      if (this.Gft != null) {
        paramInt = i + f.a.a.a.lm(10, this.Gft.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Md5);
      }
      paramInt = i;
      if (this.sVp != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sVp);
      }
      i = f.a.a.b.b.a.bx(7, this.Gfl);
      int j = f.a.a.b.b.a.bx(8, this.Gfm);
      AppMethodBeat.o(110863);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.Gfr == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        if (this.Gdr == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(110863);
          throw paramVarArgs;
        }
        AppMethodBeat.o(110863);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzc localdzc = (dzc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(110863);
          return -1;
        case 4: 
          localdzc.Gfr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 12: 
          localdzc.Gdr = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dyu();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dyu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzc.Gfs = ((dyu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdzc.Gft = ((dzb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110863);
          return 0;
        case 5: 
          localdzc.Md5 = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 6: 
          localdzc.sVp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(110863);
          return 0;
        case 7: 
          localdzc.Gfl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(110863);
          return 0;
        }
        localdzc.Gfm = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(110863);
        return 0;
      }
      AppMethodBeat.o(110863);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzc
 * JD-Core Version:    0.7.0.1
 */
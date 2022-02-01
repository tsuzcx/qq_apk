package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fs
  extends dop
{
  public int KIK;
  public int KIL;
  public int KJl;
  public int KJm;
  public long KJn;
  public long KJo;
  public ql KJp;
  public int KJq;
  public int KJr;
  public int KJs;
  public String KJt;
  public int nettype;
  public int scene;
  public String session_id;
  public String url;
  public String vid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103194);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.vid != null) {
        paramVarArgs.e(3, this.vid);
      }
      paramVarArgs.aM(4, this.scene);
      paramVarArgs.aM(5, this.KIL);
      paramVarArgs.aM(6, this.nettype);
      if (this.session_id != null) {
        paramVarArgs.e(7, this.session_id);
      }
      paramVarArgs.aM(8, this.KIK);
      paramVarArgs.aM(9, this.KJl);
      paramVarArgs.aM(10, this.KJm);
      paramVarArgs.bb(11, this.KJn);
      paramVarArgs.bb(12, this.KJo);
      if (this.KJp != null)
      {
        paramVarArgs.ni(13, this.KJp.computeSize());
        this.KJp.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(14, this.KJq);
      paramVarArgs.aM(15, this.KJr);
      paramVarArgs.aM(16, this.KJs);
      if (this.KJt != null) {
        paramVarArgs.e(17, this.KJt);
      }
      AppMethodBeat.o(103194);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1198;
      }
    }
    label1198:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.vid != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.vid);
      }
      i = i + g.a.a.b.b.a.bu(4, this.scene) + g.a.a.b.b.a.bu(5, this.KIL) + g.a.a.b.b.a.bu(6, this.nettype);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.session_id);
      }
      i = paramInt + g.a.a.b.b.a.bu(8, this.KIK) + g.a.a.b.b.a.bu(9, this.KJl) + g.a.a.b.b.a.bu(10, this.KJm) + g.a.a.b.b.a.r(11, this.KJn) + g.a.a.b.b.a.r(12, this.KJo);
      paramInt = i;
      if (this.KJp != null) {
        paramInt = i + g.a.a.a.nh(13, this.KJp.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(14, this.KJq) + g.a.a.b.b.a.bu(15, this.KJr) + g.a.a.b.b.a.bu(16, this.KJs);
      paramInt = i;
      if (this.KJt != null) {
        paramInt = i + g.a.a.b.b.a.f(17, this.KJt);
      }
      AppMethodBeat.o(103194);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(103194);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fs localfs = (fs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(103194);
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
            localfs.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 2: 
          localfs.url = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 3: 
          localfs.vid = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 4: 
          localfs.scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 5: 
          localfs.KIL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 6: 
          localfs.nettype = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 7: 
          localfs.session_id = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(103194);
          return 0;
        case 8: 
          localfs.KIK = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 9: 
          localfs.KJl = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 10: 
          localfs.KJm = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 11: 
          localfs.KJn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(103194);
          return 0;
        case 12: 
          localfs.KJo = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(103194);
          return 0;
        case 13: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ql();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ql)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfs.KJp = ((ql)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103194);
          return 0;
        case 14: 
          localfs.KJq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 15: 
          localfs.KJr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        case 16: 
          localfs.KJs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(103194);
          return 0;
        }
        localfs.KJt = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(103194);
        return 0;
      }
      AppMethodBeat.o(103194);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fs
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class zb
  extends dyl
{
  public String SbN;
  public int Slf;
  public String fileid;
  public String md5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(9588);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.fileid == null)
      {
        paramVarArgs = new b("Not all required fields were included: fileid");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(9588);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.f(2, this.fileid);
      }
      if (this.md5 != null) {
        paramVarArgs.f(3, this.md5);
      }
      if (this.SbN != null) {
        paramVarArgs.f(4, this.SbN);
      }
      paramVarArgs.aY(5, this.Slf);
      AppMethodBeat.o(9588);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label623;
      }
    }
    label623:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.fileid != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.fileid);
      }
      i = paramInt;
      if (this.md5 != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.md5);
      }
      paramInt = i;
      if (this.SbN != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.SbN);
      }
      i = g.a.a.b.b.a.bM(5, this.Slf);
      AppMethodBeat.o(9588);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.fileid == null)
        {
          paramVarArgs = new b("Not all required fields were included: fileid");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(9588);
          throw paramVarArgs;
        }
        AppMethodBeat.o(9588);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        zb localzb = (zb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(9588);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localzb.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(9588);
          return 0;
        case 2: 
          localzb.fileid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 3: 
          localzb.md5 = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9588);
          return 0;
        case 4: 
          localzb.SbN = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(9588);
          return 0;
        }
        localzb.Slf = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(9588);
        return 0;
      }
      AppMethodBeat.o(9588);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zb
 * JD-Core Version:    0.7.0.1
 */
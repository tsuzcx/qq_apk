package com.tencent.mm.plugin.qqmail.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dyy;
import com.tencent.mm.protocal.protobuf.jh;
import java.util.LinkedList;

public final class ap
  extends dyy
{
  public boolean Hnw;
  public String Hnx;
  public String Hny;
  public int Hnz;
  public int channel;
  public String fileid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(251008);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.oE(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.f(2, this.fileid);
      }
      paramVarArgs.co(3, this.Hnw);
      if (this.Hnx != null) {
        paramVarArgs.f(4, this.Hnx);
      }
      if (this.Hny != null) {
        paramVarArgs.f(5, this.Hny);
      }
      paramVarArgs.aY(6, this.Hnz);
      paramVarArgs.aY(7, this.channel);
      AppMethodBeat.o(251008);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label604;
      }
    }
    label604:
    for (paramInt = g.a.a.a.oD(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fileid != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.fileid);
      }
      i += g.a.a.b.b.a.gL(3) + 1;
      paramInt = i;
      if (this.Hnx != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Hnx);
      }
      i = paramInt;
      if (this.Hny != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.Hny);
      }
      paramInt = g.a.a.b.b.a.bM(6, this.Hnz);
      int j = g.a.a.b.b.a.bM(7, this.channel);
      AppMethodBeat.o(251008);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(251008);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(251008);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jh localjh = new jh();
            if ((localObject != null) && (localObject.length > 0)) {
              localjh.parseFrom((byte[])localObject);
            }
            localap.BaseResponse = localjh;
            paramInt += 1;
          }
          AppMethodBeat.o(251008);
          return 0;
        case 2: 
          localap.fileid = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251008);
          return 0;
        case 3: 
          localap.Hnw = ((g.a.a.a.a)localObject).abFh.AB();
          AppMethodBeat.o(251008);
          return 0;
        case 4: 
          localap.Hnx = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251008);
          return 0;
        case 5: 
          localap.Hny = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(251008);
          return 0;
        case 6: 
          localap.Hnz = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(251008);
          return 0;
        }
        localap.channel = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(251008);
        return 0;
      }
      AppMethodBeat.o(251008);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.d.ap
 * JD-Core Version:    0.7.0.1
 */
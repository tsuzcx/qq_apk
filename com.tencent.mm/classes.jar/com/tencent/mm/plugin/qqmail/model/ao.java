package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.kd;
import java.util.LinkedList;

public final class ao
  extends esc
{
  public boolean Nlk;
  public String Nll;
  public String Nlm;
  public int Nln;
  public int channel;
  public String fileid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(267045);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.fileid != null) {
        paramVarArgs.g(2, this.fileid);
      }
      paramVarArgs.di(3, this.Nlk);
      if (this.Nll != null) {
        paramVarArgs.g(4, this.Nll);
      }
      if (this.Nlm != null) {
        paramVarArgs.g(5, this.Nlm);
      }
      paramVarArgs.bS(6, this.Nln);
      paramVarArgs.bS(7, this.channel);
      AppMethodBeat.o(267045);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label600;
      }
    }
    label600:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.fileid != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.fileid);
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.Nll != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Nll);
      }
      i = paramInt;
      if (this.Nlm != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Nlm);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.Nln);
      int j = i.a.a.b.b.a.cJ(7, this.channel);
      AppMethodBeat.o(267045);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(267045);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ao localao = (ao)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(267045);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localao.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(267045);
          return 0;
        case 2: 
          localao.fileid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267045);
          return 0;
        case 3: 
          localao.Nlk = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(267045);
          return 0;
        case 4: 
          localao.Nll = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267045);
          return 0;
        case 5: 
          localao.Nlm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(267045);
          return 0;
        case 6: 
          localao.Nln = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(267045);
          return 0;
        }
        localao.channel = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(267045);
        return 0;
      }
      AppMethodBeat.o(267045);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ao
 * JD-Core Version:    0.7.0.1
 */